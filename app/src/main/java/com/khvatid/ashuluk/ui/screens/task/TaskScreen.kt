package com.khvatid.ashuluk.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TaskScreen(viewModel: TaskViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState

    Column() {
        Text(text = uiState.taskEntity.id)
    }

}