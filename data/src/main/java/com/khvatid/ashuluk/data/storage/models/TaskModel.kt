package com.khvatid.ashuluk.data.storage.models


data class TaskModel(
    val id: String = "",
    val status: Int = 1,
    val title: String = "",
    val page: String = "",
    val userId: String = ""
)
