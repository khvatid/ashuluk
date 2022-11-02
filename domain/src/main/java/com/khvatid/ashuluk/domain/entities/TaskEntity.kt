package com.khvatid.ashuluk.domain.entities

data class TaskEntity(
    val id : String = "",
    val status: TaskStatus = TaskStatus.NotStarted,
    val title: String = "",
    val page: String = "",
    val userId : String = ""
)

enum class TaskStatus(value: Int) {
    NotStarted(value = 1),
    InProgress(value = 2),
    Completed(value = 3)
}