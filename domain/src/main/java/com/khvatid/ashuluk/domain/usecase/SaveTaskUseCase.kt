package com.khvatid.ashuluk.domain.usecase

import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class SaveTaskUseCase(private val repository: KanbanRepository) {

    fun execute(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit) {
        repository.saveTask(taskEntity, onResult)
    }
}