package com.khvatid.ashuluk.domain.usecase

import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class AddTaskListenerUseCase(private val repository: KanbanRepository) {
    fun execute(
        userId: String,
        onDocumentEvent: (Boolean, TaskEntity) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        repository.addListener(
            userId = userId,
            onDocumentEvent = onDocumentEvent,
            onError = onError
        )
    }
}