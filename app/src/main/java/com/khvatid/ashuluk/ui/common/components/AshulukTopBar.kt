package com.khvatid.ashuluk.ui.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import com.khvatid.ashuluk.ui.screens.kanban.KanbanViewModel

@Composable
fun AshulukTopBar(owner: ViewModelStoreOwner, route: String?, popBack: () -> Unit) =
    when (route) {
        UiRoutes.REGISTER -> {
            BackTopBar(popBack = popBack)
        }
        UiRoutes.LOGIN -> {
            BackTopBar(popBack = popBack)
        }
        UiRoutes.KANBAN -> {
            KanbanTopBar(hiltViewModel(owner))
        }
        UiRoutes.TASK_EDIT -> {
            BackTopBar(text = "Task", popBack = popBack)
        }
        else -> {}
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BackTopBar(text: String = "Go Back", popBack: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = popBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            }
        },
        title = { Text(text = text) }
    )
}

@Composable
private fun KanbanTopBar(viewModel: KanbanViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState
    TabRow(selectedTabIndex = uiState.selectedTab,
        tabs = {
            uiState.tabs.forEachIndexed { index, title ->
                Tab(
                    selected = uiState.selectedTab == index,
                    onClick = { viewModel.onChangeSelectTab(index) },
                    text = {
                        Text(
                            text = title,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                )
            }
        }
    )
}