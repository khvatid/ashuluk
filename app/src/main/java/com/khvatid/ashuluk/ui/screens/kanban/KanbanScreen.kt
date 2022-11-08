package com.khvatid.ashuluk.ui.screens.kanban

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun KanbanScreen(viewModel: KanbanViewModel = hiltViewModel(), openTask: (String) -> Unit) {
    val uiState by viewModel.uiState
    LazyColumn() {
        uiState.tasks.filter {
            it.value.status.value == uiState.selectedTab
        }.forEach {
            item {
                TaskCard(taskEntity = it.value) {
                    openTask(it.value.id)
                }
            }
        }
    }
    DisposableEffect(viewModel) {
        viewModel.addListener()
        onDispose { viewModel.removeListener() }
    }
}