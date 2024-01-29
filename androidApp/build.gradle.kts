plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "aveek.isotopsoftware.gpsattendance.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "aveek.isotopsoftware.gpsattendance.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    val nav_version = "2.6.0"
    val koin_version = "3.4.3"
    implementation(project(":shared"))
    implementation(libs.kotlinx.coroutines.android)
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation ("io.insert-koin:koin-android:$koin_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
//    implementation("androidx.navigation:navigation-runtime-ktx:$nav_version")
//    implementation ("androidx.navigation:navigation-ui-ktx:$nav_version")
//
//    // Feature module Support
//    implementation ("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
//
//    // Testing Navigation
//    androidTestImplementation ("androidx.navigation:navigation-testing:$nav_version")

    // Jetpack Compose Integration
    //noinspection GradleDependency
    implementation ("androidx.navigation:navigation-compose:$nav_version")

}