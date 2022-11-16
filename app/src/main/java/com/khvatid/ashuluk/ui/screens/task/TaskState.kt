package com.khvatid.ashuluk.ui.screens.task

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import com.khvatid.ashuluk.domain.entities.TaskEntity
import com.khvatid.ashuluk.ui.theme.md_theme_dark_primary
import com.khvatid.ashuluk.ui.theme.md_theme_dark_secondary
import com.khvatid.ashuluk.ui.theme.md_theme_dark_tertiary

data class TaskState(
    val taskEntity: TaskEntity = TaskEntity(),
    val brush: Brush = Brush.linearGradient(
        listOf(
            md_theme_dark_primary, md_theme_dark_secondary, md_theme_dark_tertiary
        )
    )
)