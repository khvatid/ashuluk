package com.khvatid.ashuluk.ui.screens.task

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.usecase.repository.kanban.GetTaskUseCase
import com.khvatid.ashuluk.domain.usecase.repository.kanban.SaveTaskUseCase
import com.khvatid.ashuluk.domain.usecase.repository.kanban.UpdateTaskUseCase
import com.khvatid.ashuluk.domain.usecase.service.GetUserIdUseCase
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.snackbarMessage
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
@Inject constructor(
    private val getTaskUseCase: GetTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {
    private val showExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        SnackbarManager.showMessage(throwable.snackbarMessage())
    }

    private fun onError(error: Throwable) {
        SnackbarManager.showMessage(error.snackbarMessage())
    }

    var uiState: MutableState<TaskState> = mutableStateOf(TaskState())
        private set

    fun init(taskId: String) {
        viewModelScope.launch(showExceptionHandler) {
            if (taskId != UiRoutes.DEFAULT_TASK_ID) {
                getTaskUseCase.execute(taskId, onError = ::onError) {
                    uiState.value = TaskState(taskEntity = it)
                }
            } else {
                uiState.value =
                    TaskState(taskEntity = TaskEntity(userId = getUserIdUseCase.execute()))
            }
        }
    }


    fun onTitleChange(value: String) {
        val withEditTitle = uiState.value.taskEntity.copy(title = value)
        uiState.value = uiState.value.copy(taskEntity = withEditTitle)
    }

    fun onPageChange(value: String) {
        val withEditPage = uiState.value.taskEntity.copy(page = value)
        uiState.value = uiState.value.copy(taskEntity = withEditPage)
    }

    fun onDoneClick(popBack: () -> Unit) {
        viewModelScope.launch {
            if (uiState.value.taskEntity.id == "") {
                saveTaskUseCase.execute(
                    uiState.value.taskEntity.copy(
                        id = uiState.hashCode().toString()
                    )
                ) {
                    if (it == null) {
                        popBack()
                    } else {
                        SnackbarManager.showMessage(it.snackbarMessage())
                    }
                }
            } else {
                updateTaskUseCase.execute(uiState.value.taskEntity) {
                    if (it == null) {
                        popBack()
                    } else {
                        SnackbarManager.showMessage(it.snackbarMessage())
                    }
                }
            }
        }
    }

    override fun onCleared() {
        Log.i("VM", "delete TVM ")
        super.onCleared()
    }

}