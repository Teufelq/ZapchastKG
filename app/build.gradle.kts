plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.zapchastkg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.zapchastkg"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

// Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

// Jetpack Compose libraries
    implementation(platform(libs.androidx.compose.bom))           // Compose BOM (Bill of Materials)
    implementation(libs.androidx.ui)                              // Core UI components for Compose
    implementation(libs.androidx.ui.graphics)                     // Graphics support in Compose
    implementation(libs.androidx.ui.tooling.preview)              // UI Preview tools for Compose
    implementation(libs.androidx.material3)                       // Material Design 3 for Compose
    implementation(libs.material)                                 // Material Design components

// ViewModel integration with Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

// ConstraintLayout for Compose
    implementation(libs.androidx.constraintlayout.compose.v101)

// Navigation in Compose
    implementation(libs.androidx.navigation.compose.v281)

// Hilt for Dependency Injection in Compose navigation
    implementation(libs.androidx.hilt.navigation.compose.v100rc01)

// Paging 3 library for pagination in Compose and runtime
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose.v330alpha02)

// Retrofit for networking
    implementation(libs.retrofit.v290)
    implementation(libs.converter.gson.v290)

    //Dagger Hilt
    implementation (libs.hilt.android.v250)
    kapt (libs.hilt.compiler)

// Coroutines for asynchronous programming
    implementation(libs.kotlinx.coroutines.android.v139)

// Security library for cryptographic operations
    implementation(libs.androidx.security.crypto.v110alpha06)

// Testing libraries
    testImplementation(libs.junit)                              // Unit testing with JUnit
    androidTestImplementation(libs.androidx.junit)              // AndroidX JUnit for Android tests
    androidTestImplementation(libs.androidx.espresso.core)      // UI testing with Espresso
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)     // Compose-specific testing support

// Debugging tools
    debugImplementation(libs.androidx.ui.tooling)               // Tooling support for UI inspection
    debugImplementation(libs.androidx.ui.test.manifest)         // Test manifest support in debug
}

