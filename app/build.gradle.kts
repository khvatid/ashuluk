plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = Config.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //Modules
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    //Android
    implementation(AppDependencies.Android.coreKtx)
    implementation(AppDependencies.Android.splashScreen)

    //Lifecycle
    implementation(AppDependencies.Lifecycle.lifecycleKtx)
    implementation(AppDependencies.Lifecycle.activityCompose)
    implementation(AppDependencies.Lifecycle.viewModelCompose)
    implementation(AppDependencies.Lifecycle.liveData)

    //Compose
    implementation(AppDependencies.Compose.ui)

    implementation(AppDependencies.Compose.material3)
    implementation(AppDependencies.Compose.tooling)
    debugImplementation(AppDependencies.Compose.toolingTest)
    debugImplementation(AppDependencies.Compose.uiTestManifest)

    //Navigation
    implementation(AppDependencies.Navigation.navigationCompose)

    //Coil
    implementation(AppDependencies.Coil.coilCompose)

    //Hilt
    kapt(AppDependencies.Hilt.compiler)
    implementation(AppDependencies.Hilt.android)
    implementation(AppDependencies.Hilt.navigationCompose)

    //Tests
    androidTestImplementation(AppDependencies.Compose.uiTest)
    androidTestImplementation(CommonDependencies.Test.androidJUnit)
    androidTestImplementation(CommonDependencies.Test.espresso)
    testImplementation(CommonDependencies.Test.jUnit)
}