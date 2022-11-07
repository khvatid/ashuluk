package com.khvatid.ashuluk.ui.screens.kanban

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khvatid.ashuluk.domain.entities.TaskEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(taskEntity: TaskEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        content = {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = taskEntity.title,
                fontSize = 18.sp
            )
        }
    )
}