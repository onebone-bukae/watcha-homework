package me.onebone.watchahomework.ui.tracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import me.onebone.watchahomework.databinding.FragmentTrackListBinding
import me.onebone.watchahomework.ui.TracksAdapter
import me.onebone.watchahomework.ui.toEntity

@AndroidEntryPoint
class TrackListFragment: Fragment() {
	private val viewModel by viewModels<TrackListViewModel>()

	@OptIn(FlowPreview::class)
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentTrackListBinding.inflate(inflater, container, false)
		binding.lifecycleOwner = viewLifecycleOwner

		val adapter = TracksAdapter(
			onStarToggled = { entry, newValue ->
				if(newValue) {
					viewModel.addFavorite(entry.toEntity())
				}else{
					viewModel.removeFavorite(entry.toEntity())
				}
			}
		)
		binding.rvTracks.adapter = adapter

		viewLifecycleOwner.lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				launch {
					// [PagingDataAdapter.submitData] is a function that suspends until the
					// PagingData is invalidated, so if we get a new Flow<PagingData<...>>,
					// we should cancel the previous block thus we use [Flow<T>.collectLatest] here.
					// Note, the PagingData may not have been invalidated when the block cancels.
					viewModel.trackEntries.collectLatest { pagingFlow ->
						pagingFlow.collect {
							adapter.submitData(it)
						}
					}
				}

				launch {
					adapter.loadStateFlow
						// too frequent change in progress bar's visibility
						// may annoy the user!
						.debounce(300)
						.map {
							it.refresh is LoadState.Loading || it.append is LoadState.Loading
						}
						.distinctUntilChanged()
						.collect { loading ->
							binding.prgTracks.visibility = if(loading)
								View.VISIBLE else
								View.GONE
						}
				}
			}
		}

		return binding.root
	}
}
