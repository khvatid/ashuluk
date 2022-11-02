package com.khvatid.ashuluk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.khvatid.ashuluk.ui.app.App
import com.khvatid.ashuluk.ui.app.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AshulukActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (appViewModel.isLoading.value == true) {
            installSplashScreen().apply {
                setKeepOnScreenCondition {
                    !appViewModel.isLoading.value!!
                }
            }
        }
        setContent {
            App(appViewModel)
        }
    }
}
