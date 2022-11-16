package com.khvatid.ashuluk.domain.entities

data class TaskEntity(
    val id: String = "",
    val status: TaskStatus = TaskStatus.NotStarted,
    val title: String = "",
    val page: String = "",
    val userId: String = ""
)

enum class TaskStatus(val value: Int) {
    NotStarted(value = 0),
    InProgress(value = 1),
    Completed(value = 2);

    companion object {
        fun changeStatus(taskStatus: TaskStatus): TaskStatus =
            when (taskStatus) {
                NotStarted -> InProgress
                InProgress -> Completed
                Completed -> NotStarted
            }
    }
}