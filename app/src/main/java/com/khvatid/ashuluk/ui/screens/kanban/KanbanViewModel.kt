package com.khvatid.ashuluk.ui.screens.kanban

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.Closeable
import javax.inject.Inject

@HiltViewModel
class KanbanViewModel @Inject constructor() : ViewModel() {
    init {
        Log.i("VIEWMODEL", "Kanban ViewModel create")
    }

    var uiState: MutableState<KanbanState> = mutableStateOf(KanbanState())
        private set

    override fun onCleared() {
        super.onCleared()
        Log.i("VIEWMODEL", "Kanban viewModel dispose")
    }


    fun onChangeText(text: String) {
        uiState.value = uiState.value.copy(text = text)
    }
}