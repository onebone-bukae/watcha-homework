package me.onebone.watchahomework.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.watchahomework.databinding.FragmentFavoritesListBinding

@AndroidEntryPoint
class FavoritesListFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentFavoritesListBinding.inflate(inflater, container, false)

		return binding.root
	}
}
