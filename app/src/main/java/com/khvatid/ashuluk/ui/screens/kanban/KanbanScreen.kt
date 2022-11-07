package com.khvatid.ashuluk.ui.screens.kanban

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.common.components.ListButton

@Composable
fun KanbanScreen(viewModel: KanbanViewModel = hiltViewModel(), openTask: (String) -> Unit) {
    val uiState by viewModel.uiState
    LazyColumn() {

    }
}