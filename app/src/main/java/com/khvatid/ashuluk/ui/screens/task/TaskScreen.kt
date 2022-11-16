package com.khvatid.ashuluk.ui.screens.task

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(viewModel: TaskViewModel = hiltViewModel(), taskId: String, popBack: () -> Unit) {

    val uiState by viewModel.uiState

    LaunchedEffect(Unit) {
        viewModel.init(taskId)
    }

    Scaffold(
        topBar = {},
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { viewModel.onDoneClick(popBack) }) {
                    Text(text = "Done")
                }
            }
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                BasicTextField(
                    value = uiState.taskEntity.title,
                    onValueChange = viewModel::onTitleChange,
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 24.sp
                    )
                )
            }
        }
    )
}
