plugins {
    kotlin("multiplatform") version "1.9.0"
    id("com.android.application")
}

kotlin {
    android()
    ios()
    jvm("desktop")
    js(IR) { browser() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:2.3.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
            }
        }
    }
}

android {
    namespace = "org.theagora"
    compileSdk = 34
}
