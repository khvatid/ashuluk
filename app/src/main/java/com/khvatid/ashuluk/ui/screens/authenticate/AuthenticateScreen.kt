package com.khvatid.ashuluk.ui.screens.authenticate

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.navigation.UiRoutes

@Composable
fun AuthenticateScreen(
    openScreen: (String) -> Unit,
    viewModel: AuthenticateViewModel = hiltViewModel()
) {

    Column() {
        Button(onClick = { openScreen(UiRoutes.LOGIN) }) {
            Text(text = "Login to Email/Password")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign in with Google")
        }
        Button(onClick = { openScreen(UiRoutes.REGISTER) }) {
            Text(text = "Register")
        }
    }
}