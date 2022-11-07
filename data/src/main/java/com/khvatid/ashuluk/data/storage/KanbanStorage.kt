package com.khvatid.ashuluk.data.storage

import com.khvatid.ashuluk.data.storage.models.TaskModel

interface KanbanStorage {

    suspend fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskModel) -> Unit,
        onError: (Throwable) -> Unit
    )

    suspend fun removeListener()
    suspend fun getTask(
        taskId: String,
        onError: (Throwable) -> Unit,
        onSuccess: (TaskModel) -> Unit
    )

    suspend fun saveTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    suspend fun updateTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    suspend fun deleteTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    suspend fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit)

}