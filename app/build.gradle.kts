plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "me.onebone.watchahomework"
        minSdk = 21
        targetSdk = 30
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose
    }
}

dependencies {
    api(platform(project(":depsconstraints")))

    implementation(Libs.CoreKtx)
    implementation(Libs.AppCompat)
    implementation(Libs.Material)

    // jetpack compose
    implementation(Libs.Compose.Ui)
    implementation(Libs.Compose.Material)
    implementation(Libs.Compose.Material)
    implementation(Libs.ActivityCompose)

    // lifecycle
    implementation(Libs.LifecycleRuntimeKtx)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.Compose}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.Compose}")
}
