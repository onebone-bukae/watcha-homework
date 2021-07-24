object Libs {
	const val KotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib"
	const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core"

	const val MultiDex = "androidx.multidex:multidex"

	const val CoreKtx = "androidx.core:core-ktx"
	const val AppCompat = "androidx.appcompat:appcompat"
	const val Material = "com.google.android.material:material"
	const val FragmentKtx = "androidx.fragment:fragment-ktx"

	const val LifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx"

	object Room {
		const val Runtime = "androidx.room:room-runtime"
		const val Compiler = "androidx.room:room-compiler"
		const val Ktx = "androidx.room:room-ktx"
		const val Paging = "androidx.room:room-paging"
	}

	object Hilt {
		const val Android = "com.google.dagger:hilt-android"
		const val Compiler = "com.google.dagger:hilt-android-compiler"
	}

	object Fuel {
		const val Core = "com.github.kittinunf.fuel:fuel"
		const val Android = "com.github.kittinunf.fuel:fuel-android"
		const val JsonAdapter = "com.github.kittinunf.fuel:fuel-kotlinx-serialization"
	}

	const val KotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json"

	const val Retrofit = "com.squareup.retrofit2:retrofit"
	const val RetrofitJsonAdapter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter"

	const val Paging = "androidx.paging:paging-runtime"

	const val Glide = "com.github.bumptech.glide:glide"
}
