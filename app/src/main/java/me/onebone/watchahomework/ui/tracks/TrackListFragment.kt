package me.onebone.watchahomework.ui.tracks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.watchahomework.databinding.FragmentTrackListBinding

@AndroidEntryPoint
class TrackListFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentTrackListBinding.inflate(inflater, container, false)

		return binding.root
	}
}
