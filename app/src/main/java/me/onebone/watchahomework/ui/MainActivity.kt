package me.onebone.watchahomework.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
	}
}
