package com.khvatid.ashuluk.ui.screens.kanban

import com.khvatid.ashuluk.domain.entities.TaskStatus

data class KanbanState(
    val selectedTab: Int = 1
) {
    val tabs: List<String> =
        listOf(TaskStatus.NotStarted.name, TaskStatus.InProgress.name, TaskStatus.Completed.name)
}
