package com.khvatid.ashuluk.ui.common.components

import androidx.annotation.StringRes
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.khvatid.ashuluk.R
import com.khvatid.ashuluk.ui.navigation.UiRoutes

sealed interface BottomTab {
    val route: String

    @get:StringRes
    val label: Int

    val imageVector: ImageVector
}

sealed class BottomTabImp(
    override val route: String,
    @StringRes override val label: Int,
    override val imageVector: ImageVector
) : BottomTab {
    object Kanban : BottomTabImp(
        route = UiRoutes.KANBAN,
        label = R.string.kanban_screen,
        imageVector = Icons.Default.List
    )

    object Main : BottomTabImp(
        route = UiRoutes.MAIN,
        label = R.string.main_screen,
        imageVector = Icons.Default.Home,
    )

    object Settings : BottomTabImp(
        route = UiRoutes.SETTINGS,
        label = R.string.settings_screen,
        imageVector = Icons.Default.Settings
    )

    companion object {
        val tabs = listOf(Kanban, Main, Settings)
    }
}

@Composable
fun AshulukBottomBar(
    route: String?,
    tabs: List<BottomTab>,
    showBottomBar: Boolean,
    onClick: (String) -> Unit
) {
    if (showBottomBar) {
        NavigationBar {
            tabs.forEach {
                NavigationBarItem(
                    selected = it.route == route,
                    onClick = { onClick(it.route) },
                    label = {
                        Text(
                            text = stringResource(id = it.label)
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = it.imageVector,
                            contentDescription = stringResource(id = it.label)
                        )
                    }
                )
            }
        }
    }
}
