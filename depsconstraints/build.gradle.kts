plugins {
	`java-platform`
}

val activityCompose = "1.3.0-rc02"
val appCompat = "1.3.0"
val compose = Versions.Compose
val coreKtx = "1.6.0"
val material = "1.4.0"
val kotlin = Versions.Kotlin
val kotlinxSerialization = "1.2.2"
val lifecycleRuntimeKtx = "2.3.1"
val room = Versions.Room

dependencies {
	constraints {
		api("${Libs.KotlinStdlib}:$kotlin")

		api("${Libs.CoreKtx}:$coreKtx")
		api("${Libs.AppCompat}:$appCompat")
		api("${Libs.Material}:$material")
		api("${Libs.ActivityCompose}:$activityCompose")

		// jetpack compose
		api("${Libs.Compose.Ui}:$compose")
		api("${Libs.Compose.Material}:$compose")
		api("${Libs.Compose.ToolingPreview}:$compose")

		// lifecycle
		api("${Libs.LifecycleRuntimeKtx}:$lifecycleRuntimeKtx")

		// room
		api("${Libs.Room.Compiler}:$room")
		api("${Libs.Room.Runtime}:$room")
		api("${Libs.Room.Ktx}:$room")

		// kotlinx.serialization
		api("${Libs.KotlinxSerializationJson}:$kotlinxSerialization")
	}
}
