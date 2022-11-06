package com.khvatid.ashuluk.ui.screens.task

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khvatid.ashuluk.domain.entities.TaskEntity
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


class TaskViewModel
@AssistedInject constructor(
    @Assisted private val taskId: String
) : ViewModel() {
    init {
        Log.i("VM", "create Task VM for $taskId ")
    }
    override fun onCleared() {
        Log.i("VM", "delete VM for $taskId")
        super.onCleared()
    }

    val uiState: MutableState<TaskState> =
        mutableStateOf(TaskState(taskEntity = TaskEntity(taskId)))





    @AssistedFactory
    interface Factory {
        fun create(taskId: String): TaskViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {

        fun provideFactory(
            assistedFactory: Factory,
            taskId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(taskId) as T
            }
        }
    }


}

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule