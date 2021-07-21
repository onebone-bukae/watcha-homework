plugins {
	id("java-library")
	kotlin("jvm")
	kotlin("kapt")
	kotlin("plugin.serialization") version Versions.Kotlin
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	api(platform(project(":depsconstraints")))
	kapt(platform(project(":depsconstraints")))

	implementation(Libs.KotlinStdlib)

	implementation(Libs.KotlinxSerializationJson)
}
