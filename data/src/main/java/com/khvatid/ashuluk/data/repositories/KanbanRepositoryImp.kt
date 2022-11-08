package com.khvatid.ashuluk.data.repositories

import com.google.firebase.ktx.Firebase
import com.khvatid.ashuluk.data.storage.KanbanStorage
import com.khvatid.ashuluk.data.storage.models.TaskModel
import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.entities.TaskStatus
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class KanbanRepositoryImp(private val storage: KanbanStorage) : KanbanRepository {
    override suspend fun addListener(
        userId: String,
        onDocumentEvent: (Boolean, TaskEntity) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        storage.addListener(
            userId,
            onDocumentEvent = { delete, taskModel ->
                onDocumentEvent(
                    delete,
                    taskModel.toTaskEntity()
                )
            },
            onError = onError
        )
    }

    override suspend fun removeListener() {
        storage.removeListener()
    }

    override suspend fun getTask(
        taskId: String,
        onError: (Throwable) -> Unit,
        onSuccess: (TaskEntity) -> Unit
    ) {
        storage.getTask(
            taskId = taskId,
            onError = onError,
            onSuccess = { taskModel -> onSuccess(taskModel.toTaskEntity()) }
        )
    }

    override suspend fun saveTask(task: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.saveTask(task = task.toTaskModel(), onResult = onResult)
    }

    override suspend fun updateTask(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.updateTask(task = taskEntity.toTaskModel(), onResult = onResult)
    }

    override suspend fun deleteTask(taskEntity: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.deleteTask(task = taskEntity.toTaskModel(), onResult = onResult)
    }

    override suspend fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit) {
        TODO("Not yet implemented")
    }

    private fun TaskEntity.toTaskModel(): TaskModel {
        return TaskModel(
            id = this.id,
            status = this.status.value,
            title = this.title,
            page = this.page,
            userId = this.userId
        )
    }

    private fun TaskModel.toTaskEntity(): TaskEntity {
        return TaskEntity(
            id = this.id,
            status = when (this.status) {
                0 -> TaskStatus.NotStarted
                1 -> TaskStatus.InProgress
                2 -> TaskStatus.Completed
                else -> TaskStatus.NotStarted
            },
            title = this.title,
            page = this.page,
            userId = this.userId
        )
    }

}