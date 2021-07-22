package me.onebone.watchahomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import me.onebone.watchahomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

		val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
		val navController = navHost.navController
		binding.bottomNavigation.setupWithNavController(navController)
	}
}
