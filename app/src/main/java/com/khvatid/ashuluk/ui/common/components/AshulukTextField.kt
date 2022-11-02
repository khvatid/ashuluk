package com.khvatid.ashuluk.ui.common.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.VisualTransformation

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