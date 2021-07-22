package me.onebone.watchahomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.onebone.watchahomework.databinding.FragmentFavoritesListBinding

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
