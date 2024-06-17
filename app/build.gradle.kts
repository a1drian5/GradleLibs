plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.androidxNavigationSafeArgs)
}

android {
    namespace = "com.example.gradlefix"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gradlefix"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //View Model
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.common.java8)

    //Room
    implementation(libs.androidx.room.room.ktx)
    implementation(libs.androidx.room.room.runtime)
    kapt(libs.kapt.androidx.room.room.compiler)

    //Dagger-Hilt
    implementation(libs.hilt.android)
    kapt(libs.kapt.hilt.compiler)

    //Retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.gsonConverter)
    implementation(libs.squareup.loggingInterceptor)

    //Coroutines
    implementation(libs.coroutinesAndroid)

    //Glide
    implementation(libs.glide)
    annotationProcessor(libs.glideCompiler)

    //Navigation
    implementation(libs.navigationFragmentKtx)
    implementation(libs.navigationUiKtx)

    //Activity
    implementation(libs.activity)

    //Pag
    implementation(libs.paging)

}