package com.khvatid.ashuluk.domain.usecase.repository.kanban

import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class DeleteTaskUseCase(private val repository: KanbanRepository) {
    suspend fun execute(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit) {
        repository.deleteTask(taskEntity = taskEntity, onResult = onResult)
    }
}