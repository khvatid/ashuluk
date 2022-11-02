package com.khvatid.ashuluk.ui.common.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import com.khvatid.ashuluk.ui.screens.kanban.KanbanViewModel

@Composable
fun AshulukTopBar(owner: ViewModelStoreOwner, route: String?, popBack: () -> Unit) =
    when (route) {
        UiRoutes.REGISTER -> {
            BackTopBar(popBack)
        }
        UiRoutes.LOGIN -> {
            BackTopBar(popBack)
        }
        UiRoutes.KANBAN -> {
            KanbanTopBar(hiltViewModel(owner))
        }
        else -> {}
    }

@Composable
private fun BackTopBar(popBack: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = popBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back"
                )
            }
        },
        title = { Text(text = "Go Back") }
    )
}

@Composable
private fun KanbanTopBar(viewModel: KanbanViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState

}