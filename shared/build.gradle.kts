plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("kapt")
	id("dagger.hilt.android.plugin")
}

android {
	compileSdkVersion(Versions.Sdk.Compile)
	buildToolsVersion = "30.0.3"

	defaultConfig {
		minSdkVersion(Versions.Sdk.Min)
		targetSdkVersion(Versions.Sdk.Target)
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")

		buildConfigField("String", "ITUNES_API_BASE_URL", "\"https://itunes.apple.com/\"")
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
	}
}

dependencies {
	api(platform(project(":depsconstraints")))
	kapt(platform(project(":depsconstraints")))

	api(project(":model"))
	api(project(":database"))

	implementation(Libs.KotlinStdlib)
	implementation(Libs.Coroutines)
	implementation(Libs.CoreKtx)
	implementation(Libs.AppCompat)
	implementation(Libs.Material)

	// hilt
	implementation(Libs.Hilt.Android)
	kapt(Libs.Hilt.Compiler)

	// kotlinx.serialization
	implementation(Libs.KotlinxSerializationJson)

	// fuel
	implementation(Libs.Fuel.Core)
	implementation(Libs.Fuel.Android)
	implementation(Libs.Fuel.JsonAdapter)

	// paging library
	implementation(Libs.Paging)

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
