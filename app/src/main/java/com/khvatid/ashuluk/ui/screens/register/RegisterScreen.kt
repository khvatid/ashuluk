package com.khvatid.ashuluk.ui.screens.register

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.common.components.AshulukTextField

@Composable
fun RegisterScreen(
    onBackPress: () -> Unit,
    openSingleTop: (String) -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val state by viewModel.uiState

        Text(
            text = "REGISTRATION",
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
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
            label = if (!state.isErrorPassword) "password" else "password < 6 symbols",
            isError = state.isErrorPassword,
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = {}),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                autoCorrect = false,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        AshulukTextField(
            value = state.passwordReply,
            onValueChange = viewModel::onPasswordReplyChanged,
            label = if (!state.isErrorPasswordReply) "replay password" else "password does not match",
            singleLine = true,
            isError = state.isErrorPasswordReply,
            keyboardActions = KeyboardActions(onDone = {}),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                autoCorrect = false,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
        Row(

            horizontalArrangement = Arrangement.End,
        ) {
            Button(
                onClick = { viewModel.createAccount(openSingleTop = openSingleTop) },
                enabled = state.isEnable
            ) {
                Text(text = "Accept")
            }
        }


    }
}