package com.khvatid.ashuluk.domain.usecase.repository.kanban

import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class UpdateTaskUseCase(private val repository: KanbanRepository) {
    suspend fun execute(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit) {
        repository.updateTask(taskEntity = taskEntity, onResult = onResult)
    }
}