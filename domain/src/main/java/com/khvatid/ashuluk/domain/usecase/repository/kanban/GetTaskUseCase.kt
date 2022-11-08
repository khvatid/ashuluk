package com.khvatid.ashuluk.domain.usecase.repository.kanban

import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class GetTaskUseCase(private val repository: KanbanRepository) {

    suspend fun execute(taskId: String, onError: (Throwable) -> Unit, onSuccess: (TaskEntity) -> Unit) {
        repository.getTask(taskId = taskId, onError = onError, onSuccess = onSuccess)
    }
}