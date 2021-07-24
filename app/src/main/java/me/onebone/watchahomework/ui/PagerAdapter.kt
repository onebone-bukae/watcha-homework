package me.onebone.watchahomework.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.onebone.watchahomework.ui.favorites.FavoritesListFragment
import me.onebone.watchahomework.ui.tracks.TrackListFragment

class PagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
	override fun getItemCount(): Int = 2

	override fun createFragment(position: Int): Fragment = when(position) {
		0 -> TrackListFragment()
		1 -> FavoritesListFragment()
		else -> throw IllegalArgumentException("invalid position $position given")
	}
}
