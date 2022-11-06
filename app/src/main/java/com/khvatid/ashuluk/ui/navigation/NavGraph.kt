package com.khvatid.ashuluk.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.khvatid.ashuluk.AshulukActivity
import com.khvatid.ashuluk.domain.util.ParentDestination
import com.khvatid.ashuluk.ui.app.AppState
import com.khvatid.ashuluk.ui.screens.authenticate.AuthenticateScreen
import com.khvatid.ashuluk.ui.screens.kanban.KanbanScreen
import com.khvatid.ashuluk.ui.screens.login.LoginScreen
import com.khvatid.ashuluk.ui.screens.main.MainScreen
import com.khvatid.ashuluk.ui.screens.register.RegisterScreen
import com.khvatid.ashuluk.ui.screens.settings.SettingsScreen
import com.khvatid.ashuluk.ui.screens.task.TaskScreen
import com.khvatid.ashuluk.ui.screens.task.TaskViewModel
import dagger.hilt.android.EntryPointAccessors

fun NavGraphBuilder.ashulukNavGraph(appState: AppState) {
    navigation(
        startDestination = UiRoutes.AUTHENTICATE,
        builder = { authenticateGraph(appState) },
        route = ParentDestination.AUTH
    )
    navigation(
        startDestination = UiRoutes.MAIN,
        builder = { mainGraph(appState) },
        route = ParentDestination.MAIN
    )
}

private fun NavGraphBuilder.authenticateGraph(appState: AppState) {
    composable(route = UiRoutes.AUTHENTICATE) {
        AuthenticateScreen(
            openScreen = { appState.navigate(it) },
            viewModel = hiltViewModel(appState.viewModelStoreOwner)
        )
    }
    composable(route = UiRoutes.LOGIN) {
        LoginScreen(
            onBackPress = appState::popBack,
            openSingleTop = { appState.clearAndNavigate(it) },
            viewModel = hiltViewModel(appState.viewModelStoreOwner)
        )
    }
    composable(route = UiRoutes.REGISTER) {
        RegisterScreen(
            onBackPress = appState::popBack,
            openSingleTop = { appState.clearAndNavigate(it) },
            viewModel = hiltViewModel(appState.viewModelStoreOwner)
        )
    }
}

private fun NavGraphBuilder.mainGraph(appState: AppState) {

    composable(route = UiRoutes.SETTINGS) {
        SettingsScreen(
            viewModel = hiltViewModel(appState.viewModelStoreOwner),
            clearAndNavigate = appState::clearAndNavigate
        )
    }

    composable(route = UiRoutes.KANBAN) {
        KanbanScreen(
            viewModel = hiltViewModel(appState.viewModelStoreOwner),
            openTask = {
                navigateToTask(appState.navController, it)
            }
        )
    }

    composable(route = UiRoutes.MAIN) {
        MainScreen(
            viewModel = hiltViewModel(appState.viewModelStoreOwner)
        )
    }

    composable(
        route = "${UiRoutes.TASK}/{taskId}",
        arguments = listOf(
            navArgument("taskId") {
                type = NavType.StringType
            }
        )
    ) {
        TaskScreen(
            taskViewModel(
                taskId = it.arguments?.getString("taskId")!!,
            )
        )
    }

}

@Composable
private fun taskViewModel(taskId: String): TaskViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        AshulukActivity.ViewModelFactoryProvider::class.java
    ).taskViewModelFactory()

    return viewModel(
        factory = TaskViewModel.provideFactory(factory, taskId),
    )
}

private fun navigateToTask(navController: NavController, taskId: String) {
    navController.navigate("${UiRoutes.TASK}/$taskId")
}