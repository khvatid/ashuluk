package com.khvatid.ashuluk.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(viewModel: TaskViewModel = hiltViewModel(), taskId: String, popBack: () -> Unit) {

    val uiState by viewModel.uiState

    LaunchedEffect(Unit) {
        viewModel.init(taskId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = uiState.taskEntity.title, onValueChange = viewModel::onTitleChange)

        BasicTextField(value = uiState.taskEntity.page, onValueChange = viewModel::onPageChange)

        Row() {
            Button(onClick = { viewModel.onDoneClick(popBack) }) {
                Text(text = "Done")
            }
        }
    }

}