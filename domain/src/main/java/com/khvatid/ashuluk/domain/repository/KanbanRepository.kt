package com.khvatid.ashuluk.domain.repository

import com.khvatid.ashuluk.domain.entities.TaskEntity

interface KanbanRepository {
    fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskEntity) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun removeListener()
    fun getTask(taskId: String, onError: (Throwable) -> Unit, onSuccess: (TaskEntity) -> Unit)
    fun saveTask(task: TaskEntity, onResult: (Throwable?) -> Unit)
    fun updateTask(task: TaskEntity, onResult: (Throwable?) -> Unit)
    fun deleteTask(task: TaskEntity, onResult: (Throwable?) -> Unit)
    fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit)

}