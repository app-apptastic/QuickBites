plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.apptastic.quickbites"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.apptastic.quickbites"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"${project.properties["BASE_URL_DEBUG"]}\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"${project.properties["BASE_URL_RELEASE"]}\"")
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
        buildConfig = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // work manager
    implementation(libs.androidx.work.runtime)
    // (Optional) WorkManager with Kotlin Coroutines
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.hilt.android.v250)
    ksp(libs.hilt.android.compiler)
//    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.work.v100)

    // kotlin-coroutines
    implementation(libs.kotlinx.coroutines.android)

    // room db
    implementation(libs.androidx.room.runtime)
//    kapt("androidx.room:room-compiler:2.6.1")
    // Use KSP instead of kapt
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // viewmodel
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Hilt Dependencies
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // hilt-navigation
    implementation(libs.androidx.hilt.navigation.compose)

    // glide
    implementation(libs.compose)

    implementation(libs.kotlinx.coroutines.android.v139)

    // retrofit
    implementation(libs.retrofit)
    // Gson convertor (json to kotlin objects and vice-versa), object mapping
    implementation(libs.converter.gson)
    //moshi
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)

    implementation(libs.moshi)
    implementation(libs.moshi.kotlin.codegen)
    ksp(libs.moshi.kotlin.codegen)

    //chucker
    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)

    // logging interceptor
    implementation(libs.logging.interceptor)

    // firebase-bom
    implementation(platform(libs.firebase.bom))
//     analytics
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.firebase.crashlytics.ktx)

    // lottie
    implementation(libs.lottie.compose)
}