plugins {
	id("com.android.library")
	kotlin("android")
}

android {
	compileSdk = 30
	buildToolsVersion = "30.0.3"

	defaultConfig {
		minSdk = Versions.Sdk.Min
		targetSdk = Versions.Sdk.Target
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
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

	implementation(Libs.KotlinStdlib)
	implementation(Libs.Coroutines)
	implementation(Libs.CoreKtx)
	implementation(Libs.AppCompat)
	implementation(Libs.Material)

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
