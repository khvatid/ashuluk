package com.khvatid.ashuluk.ui.screens.kanban

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun KanbanScreen(viewModel: KanbanViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState
    LazyColumn() {

    }
}