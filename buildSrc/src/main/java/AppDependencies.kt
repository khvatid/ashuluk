object AppDependencies {

    object Compose {
        private const val version = "1.2.0"

        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:$version"

        /**
         * Debug implementation
         */
        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"

        /**
         * Debug implementation
         */
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"

        /**
         *  android Test Implementation
         */
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.5.2"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.8.0"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0"
    }

    object Lifecycle {
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
        const val liveData = "androidx.compose.runtime:runtime-livedata:1.1.1"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
    }

    object Coil{
        const val coilCompose = "io.coil-kt:coil-compose:2.1.0"
    }

    object Hilt{
        private const val version = "2.44"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

}