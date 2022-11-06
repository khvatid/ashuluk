package com.khvatid.ashuluk.ui.common.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.khvatid.ashuluk.ui.app.AppState
import com.khvatid.ashuluk.ui.navigation.UiRoutes

@Composable
fun AshulukFAB(appState: AppState) {
    when (appState.currentRoute) {
        UiRoutes.KANBAN -> {
            FloatingActionButton(
                onClick = { appState.navigate(UiRoutes.TASK_EDIT) },
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = "Add") }
            )

        }
        else -> {}
    }
}