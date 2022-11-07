package com.khvatid.ashuluk.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.common.components.AshulukTextField

@Composable
fun LoginScreen(
    onBackPress: () -> Unit,
    openSingleTop: (String) -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val state by viewModel.uiState

        Text(
            text = "LOGIN TO EMAIL",
            fontSize = 26.sp
        )

        AshulukTextField(
            value = state.mail,
            onValueChange = viewModel::onEmailChange,
            label = "email",
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = {}),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
        )
        AshulukTextField(
            value = state.password,
            onValueChange = viewModel::onPasswordChange,
            label = "password",
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = {}),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                autoCorrect = false,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = { viewModel.signInToEmailAndPassword(openSingleTop) }) {
            Text(text = "sign in")
        }
    }
}