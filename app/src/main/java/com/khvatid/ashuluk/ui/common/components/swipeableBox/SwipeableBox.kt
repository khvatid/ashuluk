package com.khvatid.ashuluk.ui.common.components.swipeableBox

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun SwipeableBox(
    action : ()->Unit,
    actionFeedback : ()->Unit = {},
    content: @Composable() (BoxScope.() -> Unit),
    belowContent: @Composable() (RowScope.() -> Unit)
) {
    var offsetX by remember { mutableStateOf(0f) }
    val draggableState = rememberDraggableState(onDelta = {
        if (offsetX + it > 0 && offsetX + it < 270){
            offsetX += it
            if (offsetX > 250){
                actionFeedback()
            }
        }
    })
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(modifier = Modifier,
            content = belowContent)
        Box(
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), 0) }
                .draggable(
                    state = draggableState,
                    orientation = Orientation.Horizontal,
                    onDragStopped = {
                        if (offsetX > 250){
                            action()
                        }
                            offsetX = 0f
                    }
                )
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            content = content
        )
    }
}
