package me.onebone.watchahomework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import me.onebone.watchahomework.R
import me.onebone.watchahomework.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = DataBindingUtil
			.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

		val adapter = PagerAdapter(this)
		binding.pager.adapter = adapter

		binding.bottomNavigation.setOnItemSelectedListener {
			binding.pager.currentItem = when(it.itemId) {
				R.id.menu_tracks -> 0
				R.id.menu_favorites -> 1
				else -> throw IllegalArgumentException("invalid item id")
			}

			true
		}

		binding.pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
			override fun onPageSelected(position: Int) {
				binding.bottomNavigation.menu.getItem(when(position) {
					0 -> 0
					1 -> 1
					else -> throw IllegalArgumentException("invalid position given: $position")
				}).isChecked = true
			}
		})
	}
}
