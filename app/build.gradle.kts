plugins {
	id("com.android.application")
	kotlin("android")
}

android {
	compileSdk = 30
	buildToolsVersion = "30.0.3"

	defaultConfig {
		applicationId = "me.onebone.watchahomework"
		minSdk = Versions.Build.Min
		targetSdk = Versions.Build.Target
		versionCode = 1
		versionName = "1.0"

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

	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	api(platform(project(":depsconstraints")))

	implementation(project(":model"))
	// implementation(project(":database"))

	implementation(Libs.KotlinStdlib)

	implementation(Libs.CoreKtx)
	implementation(Libs.AppCompat)
	implementation(Libs.Material)

	// lifecycle
	implementation(Libs.LifecycleRuntimeKtx)

	// navigation component
	implementation(Libs.Navigation.FragmentKtx)
	implementation(Libs.Navigation.UiKtx)

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
