package com.khvatid.ashuluk.ui.common.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AshulukTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    singleLine: Boolean = false,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None
) = OutlinedTextField(
    value = value,
    onValueChange = onValueChange,
    singleLine = singleLine,
    isError = isError,
    label = { Text(text = label) },
    keyboardActions = keyboardActions,
    keyboardOptions = keyboardOptions,
    visualTransformation = visualTransformation
)