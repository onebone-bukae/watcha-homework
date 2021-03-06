plugins {
	`java-platform`
}

val appCompat = "1.3.0"
val coreKtx = "1.6.0"
val coroutines = "1.5.1"
val fuel = Versions.Fuel
val fragmentKtx = "1.3.5"
val glide = "4.11.0"
val hilt = Versions.Hilt
val material = "1.4.0"
val multidex = "2.0.1"
val kotlin = Versions.Kotlin
val kotlinxSerialization = "1.2.2"
val lifecycleRuntimeKtx = "2.4.0-alpha02"
val paging = "3.0.1"
val room = Versions.Room
val roomPaging = "2.4.0-alpha04"

dependencies {
	constraints {
		api("${Libs.KotlinStdlib}:$kotlin")
		api("${Libs.Coroutines}:$coroutines")

		api("${Libs.CoreKtx}:$coreKtx")
		api("${Libs.AppCompat}:$appCompat")
		api("${Libs.Material}:$material")
		api("${Libs.FragmentKtx}:$fragmentKtx")
		api("${Libs.MultiDex}:$multidex")

		// lifecycle
		api("${Libs.LifecycleRuntimeKtx}:$lifecycleRuntimeKtx")

		// room
		api("${Libs.Room.Compiler}:$room")
		api("${Libs.Room.Runtime}:$room")
		api("${Libs.Room.Ktx}:$room")
		api("${Libs.Room.Paging}:$roomPaging")

		// kotlinx.serialization
		api("${Libs.KotlinxSerializationJson}:$kotlinxSerialization")

		// hilt
		api("${Libs.Hilt.Android}:$hilt")
		api("${Libs.Hilt.Compiler}:$hilt")

		// fuel
		api("${Libs.Fuel.Core}:$fuel")
		api("${Libs.Fuel.Android}:$fuel")
		api("${Libs.Fuel.JsonAdapter}:$fuel")

		// paging library
		api("${Libs.Paging}:$paging")

		// glide
		api("${Libs.Glide}:$glide")
	}
}
