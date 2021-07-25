package me.onebone.watchahomework

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {
	override fun onCreate() {
		super.onCreate()

		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
	}

	override fun attachBaseContext(base: Context) {
		super.attachBaseContext(base)

		MultiDex.install(this)
	}
}
