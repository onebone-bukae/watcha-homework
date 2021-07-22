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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.onebone.watchahomework.databinding.FragmentTrackListBinding

@AndroidEntryPoint
class TrackListFragment: Fragment() {
	private val viewModel by viewModels<TrackListViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentTrackListBinding.inflate(inflater, container, false)

		viewLifecycleOwner.lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.tracks.collect {
					// TODO
				}
			}
		}

		return binding.root
	}
}
