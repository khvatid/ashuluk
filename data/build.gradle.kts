plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "${Config.namespace}.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    //Modules
    implementation(project(mapOf("path" to ":domain")))

    //PlayService
    implementation(DataDependencies.GoogleService.playService)

    //Firebase
    implementation(DataDependencies.FireBase.authenticate)
    implementation(DataDependencies.FireBase.firestore)

    //Room
    kapt(DataDependencies.Room.compiler)
    implementation(DataDependencies.Room.ktx)
    implementation(DataDependencies.Room.paging)

    testImplementation(CommonDependencies.Test.jUnit)
    androidTestImplementation(CommonDependencies.Test.androidJUnit)
}