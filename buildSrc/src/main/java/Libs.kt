object Libs {
	const val KotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
	const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core"

	const val CoreKtx = "androidx.core:core-ktx"
	const val AppCompat = "androidx.appcompat:appcompat"
	const val Material = "com.google.android.material:material"

	const val LifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx"

	object Room {
		const val Runtime = "androidx.room:room-runtime"
		const val Compiler = "androidx.room:room-compiler"
		const val Ktx = "androidx.room:room-ktx"
	}

	object Navigation {
		const val FragmentKtx = "androidx.navigation:navigation-fragment-ktx"
		const val UiKtx = "androidx.navigation:navigation-ui-ktx"
	}

	object Hilt {
		const val Android = "com.google.dagger:hilt-android"
		const val Compiler = "com.google.dagger:hilt-android-compiler"
	}

	const val KotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json"

	const val Retrofit = "com.squareup.retrofit2:retrofit"
	const val RetrofitJsonAdapter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter"
}
