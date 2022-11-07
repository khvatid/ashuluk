package com.khvatid.ashuluk.domain.repository

import com.khvatid.ashuluk.domain.entities.TaskEntity

interface KanbanRepository {
    suspend fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskEntity) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun removeListener()
    suspend fun getTask(taskId: String, onError: (Throwable) -> Unit, onSuccess: (TaskEntity) -> Unit)
    suspend fun saveTask(task: TaskEntity, onResult: (Throwable?) -> Unit)
   suspend fun updateTask(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit)
    suspend fun deleteTask(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit)
    suspend fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit)

}