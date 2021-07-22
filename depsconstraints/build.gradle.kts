plugins {
	`java-platform`
}

val activityCompose = "1.3.0-rc02"
val appCompat = "1.3.0"
val coreKtx = "1.6.0"
val coroutines = "1.5.1"
val hilt = Versions.Hilt
val material = "1.4.0"
val navigation = Versions.Navigation
val kotlin = Versions.Kotlin
val kotlinxSerialization = "1.2.2"
val lifecycleRuntimeKtx = "2.3.1"
val retrofit = "2.9.0"
val retrofitJsonAdapter = "0.8.0"
val room = Versions.Room

dependencies {
	constraints {
		api("${Libs.KotlinStdlib}:$kotlin")
		api("${Libs.Coroutines}:$coroutines")

		api("${Libs.CoreKtx}:$coreKtx")
		api("${Libs.AppCompat}:$appCompat")
		api("${Libs.Material}:$material")

		// lifecycle
		api("${Libs.LifecycleRuntimeKtx}:$lifecycleRuntimeKtx")

		// room
		api("${Libs.Room.Compiler}:$room")
		api("${Libs.Room.Runtime}:$room")
		api("${Libs.Room.Ktx}:$room")

		// kotlinx.serialization
		api("${Libs.KotlinxSerializationJson}:$kotlinxSerialization")

		// navigation component
		api("${Libs.Navigation.FragmentKtx}:$navigation")
		api("${Libs.Navigation.UiKtx}:$navigation")

		// hilt
		api("${Libs.Hilt.Android}:$hilt")
		api("${Libs.Hilt.Compiler}:$hilt")

		// retrofit
		api("${Libs.Retrofit}:$retrofit")
		api("${Libs.RetrofitJsonAdapter}:$retrofitJsonAdapter")
	}
}
