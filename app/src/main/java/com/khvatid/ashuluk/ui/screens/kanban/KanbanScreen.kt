package com.khvatid.ashuluk.ui.screens.kanban

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.common.components.swipeableBox.SwipeableBox

@Composable
fun KanbanScreen(viewModel: KanbanViewModel = hiltViewModel(), openTask: (String) -> Unit) {
    val uiState by viewModel.uiState
    LazyColumn() {
        uiState.tasks.filter {
            it.value.status.value == uiState.selectedTab
        }.forEach {
            item {
                SwipeableBox(action = { viewModel.changeTaskStatus(it.value) }, content = {
                    TaskCard(taskEntity = it.value) {
                        openTask(it.value.id)
                    }
                }, belowContent = {
                    Text(
                        "->"
                    )
                })

            }
        }
    }
    DisposableEffect(viewModel) {
        viewModel.addListener()
        onDispose { viewModel.removeListener() }
    }
}