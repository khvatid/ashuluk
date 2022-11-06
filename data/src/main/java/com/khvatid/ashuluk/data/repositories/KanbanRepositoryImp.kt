package com.khvatid.ashuluk.data.repositories

import com.khvatid.ashuluk.data.storage.KanbanStorage
import com.khvatid.ashuluk.data.storage.models.TaskModel
import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.domain.entities.TaskStatus
import com.khvatid.ashuluk.domain.repository.KanbanRepository

class KanbanRepositoryImp(private val storage: KanbanStorage) : KanbanRepository {
    override fun addListener(
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

    override fun removeListener() {
        storage.removeListener()
    }

    override fun getTask(
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

    override fun saveTask(task: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.saveTask(task = task.toTaskModel(), onResult = onResult)
    }

    override fun updateTask(task: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.updateTask(task = task.toTaskModel(), onResult = onResult)
    }

    override fun deleteTask(task: TaskEntity, onResult: (Throwable?) -> Unit) {
        storage.deleteTask(task = task.toTaskModel(), onResult = onResult)
    }

    override fun deleteAllTasks(userId: String, onResult: (Throwable?) -> Unit) {
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
                1 -> TaskStatus.NotStarted
                2 -> TaskStatus.InProgress
                3 -> TaskStatus.Completed
                else -> TaskStatus.NotStarted
            },
            title = this.title,
            page = this.page,
            userId = this.userId
        )
    }

}