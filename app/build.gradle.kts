plugins {
	id("com.android.application")
	kotlin("android")
	kotlin("kapt")
	id("dagger.hilt.android.plugin")
}

android {
	compileSdkVersion(Versions.Sdk.Compile)
	buildToolsVersion = "30.0.3"

	defaultConfig {
		applicationId = "me.onebone.watchahomework"
		minSdkVersion(Versions.Sdk.Min)
		targetSdkVersion(Versions.Sdk.Target)
		versionCode = 1
		versionName = "1.0"
		multiDexEnabled = true

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
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

	buildFeatures {
		dataBinding = true
	}

	kotlinOptions {
		jvmTarget = "1.8"
		freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
	}
}

dependencies {
	api(platform(project(":depsconstraints")))
	kapt(platform(project(":depsconstraints")))

	implementation(project(":shared"))

	implementation(Libs.KotlinStdlib)
	implementation(Libs.Coroutines)

	implementation(Libs.MultiDex)

	implementation(Libs.CoreKtx)
	implementation(Libs.AppCompat)
	implementation(Libs.Material)
	implementation(Libs.FragmentKtx)

	// lifecycle
	implementation(Libs.LifecycleRuntimeKtx)

	// paging library
	implementation(Libs.Paging)

	// glide
	implementation(Libs.Glide)

	// hilt
	implementation(Libs.Hilt.Android)
	kapt(Libs.Hilt.Compiler)

	implementation(Libs.KotlinxSerializationJson)

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
