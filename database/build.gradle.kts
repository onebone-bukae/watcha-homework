plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("kapt")
}

android {
	compileSdk = 30
	buildToolsVersion = "30.0.3"

	defaultConfig {
		minSdk = Versions.Sdk.Min
		targetSdk = Versions.Sdk.Target
		version = "1.0"

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
	kapt(platform(project(":depsconstraints")))

	implementation(Libs.CoreKtx)
	implementation(Libs.AppCompat)
	implementation(Libs.Material)

	// room
	kapt(Libs.Room.Compiler)
	api(Libs.Room.Runtime)
	api(Libs.Room.Ktx)
	implementation(Libs.Room.Paging)

	api(Libs.Paging)

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
