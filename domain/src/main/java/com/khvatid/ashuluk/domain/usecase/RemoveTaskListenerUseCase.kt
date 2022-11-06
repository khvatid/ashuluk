package com.khvatid.ashuluk.domain.usecase

import com.khvatid.ashuluk.domain.repository.KanbanRepository

class RemoveTaskListenerUseCase(private val repository: KanbanRepository) {
    fun execute() {
        repository.removeListener()
    }
}