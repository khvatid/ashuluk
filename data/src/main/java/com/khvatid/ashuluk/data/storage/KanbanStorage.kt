package com.khvatid.ashuluk.data.storage

import com.khvatid.ashuluk.data.storage.models.TaskModel

interface KanbanStorage {

    fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskModel) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun removeListener()
    fun getTask(taskId: String, onError: (Throwable) -> Unit, onSuccess: (TaskModel) -> Unit)
    fun saveTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    fun updateTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    fun deleteTask(task: TaskModel, onResult: (Throwable?) -> Unit)
    fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit)

}