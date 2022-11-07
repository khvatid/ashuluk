package com.khvatid.ashuluk.ui.screens.kanban

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.usecase.repository.kanban.AddTaskListenerUseCase
import com.khvatid.ashuluk.domain.usecase.repository.kanban.RemoveTaskListenerUseCase
import com.khvatid.ashuluk.domain.usecase.repository.kanban.UpdateTaskUseCase
import com.khvatid.ashuluk.domain.usecase.service.GetUserIdUseCase
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.snackbarMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KanbanViewModel @Inject constructor(
    private val addTaskListenerUseCase: AddTaskListenerUseCase,
    private val removeTaskListenerUseCase: RemoveTaskListenerUseCase,
    private val getUserIdUseCase: GetUserIdUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) : ViewModel() {
    init {
        Log.i("VIEWMODEL", "Kanban ViewModel create")
    }

    var uiState: MutableState<KanbanState> = mutableStateOf(KanbanState())
        private set

    fun addListener() {
        viewModelScope.launch(showExceptionHandler) {
            addTaskListenerUseCase.execute(
                getUserIdUseCase.execute(),
                this@KanbanViewModel::onDocumentEvent,
                this@KanbanViewModel::onError
            )
        }
    }

    fun removeListener() {
        viewModelScope.launch(showExceptionHandler) {
            removeTaskListenerUseCase.execute()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("VIEWMODEL", "Kanban viewModel dispose")
    }

    fun onChangeSelectTab(value: Int) {
        uiState.value = uiState.value.copy(selectedTab = value)
    }

    private fun onDocumentEvent(wasDocumentDeleted: Boolean, task: TaskEntity) {
        uiState.value = uiState.value.copy(
            tasks = uiState.value.tasks.toMutableMap().apply {
                if (wasDocumentDeleted) {
                    this.remove(task.id)
                } else {
                    this[task.id] = task
                }
            }
        )
    }

    private val showExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        SnackbarManager.showMessage(throwable.snackbarMessage())
    }

    private fun onError(error: Throwable) {
        SnackbarManager.showMessage(error.snackbarMessage())
    }

}