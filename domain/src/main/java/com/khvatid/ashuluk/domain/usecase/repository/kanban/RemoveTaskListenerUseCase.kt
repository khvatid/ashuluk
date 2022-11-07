package com.khvatid.ashuluk.domain.usecase.repository.kanban

import com.khvatid.ashuluk.domain.repository.KanbanRepository

class RemoveTaskListenerUseCase(private val repository: KanbanRepository) {
    suspend fun execute() {
        repository.removeListener()
    }
}