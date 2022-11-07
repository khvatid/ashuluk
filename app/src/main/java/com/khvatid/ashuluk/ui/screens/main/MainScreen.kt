package com.khvatid.ashuluk.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    Column {
        Text(text = "main screen")
    }

}