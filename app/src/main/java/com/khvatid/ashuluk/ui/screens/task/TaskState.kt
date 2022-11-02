package com.khvatid.ashuluk.ui.screens.task

import com.khvatid.ashuluk.domain.entities.TaskEntity

data class TaskState(
    val taskEntity: TaskEntity = TaskEntity(),
)