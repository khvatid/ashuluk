package com.khvatid.ashuluk.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.khvatid.ashuluk.ui.common.components.ListButton

@Composable
fun SettingsScreen(
    clearAndNavigate: (String) -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ListButton(
            text = "Sign out",
            onClick = { viewModel.signOut { clearAndNavigate(it) } }
        )
        ListButton(
            text = "Delete",
            onClick = { viewModel.deleteAccount { clearAndNavigate(it) } },
            color = Color.Red
        )
    }
}