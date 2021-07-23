package me.onebone.watchahomework.ui.favorites

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
import me.onebone.watchahomework.databinding.FragmentFavoritesListBinding

@AndroidEntryPoint
class FavoritesListFragment: Fragment() {
	private val viewModel by viewModels<FavoritesViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentFavoritesListBinding.inflate(inflater, container, false)
		binding.lifecycleOwner = viewLifecycleOwner

		val adapter = FavoritesAdapter()

		binding.rvFavorites.adapter = adapter

		viewLifecycleOwner.lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) {
				viewModel.favorites.collect {
					adapter.submitData(it)
				}
			}
		}

		return binding.root
	}
}
