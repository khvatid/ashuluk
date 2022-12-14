package com.khvatid.ashuluk.ui.navigation


object UiRoutes {
    const val AUTHENTICATE = "authenticate_screen"
    const val LOGIN = "${AUTHENTICATE}/login_screen"
    const val REGISTER = "${AUTHENTICATE}/register_screen"
    const val MAIN = "main_screen"
    const val SETTINGS = "settings_screen"
    const val KANBAN = "kanban_screen"
    const val TASK = "task_screen"
    const val DEFAULT_TASK_ID = "DEF"
    const val TASK_EDIT = "$TASK/$DEFAULT_TASK_ID"

}