package com.khvatid.ashuluk.ui.screens.kanban

import com.khvatid.ashuluk.domain.entities.TaskStatus

data class KanbanState(
    val selectedTab: Int = 1,
    val tasks: List<String> = listOf("task12", "task40", "task32")
) {
    val tabs: List<String> =
        listOf(TaskStatus.NotStarted.name, TaskStatus.InProgress.name, TaskStatus.Completed.name)
}
