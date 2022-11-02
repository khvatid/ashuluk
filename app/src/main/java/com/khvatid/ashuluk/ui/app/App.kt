package com.khvatid.ashuluk.ui.app

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.khvatid.ashuluk.ui.common.components.AshulukBottomBar
import com.khvatid.ashuluk.ui.common.components.AshulukTopBar
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.navigation.ashulukNavGraph
import com.khvatid.ashuluk.ui.theme.AshulukTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun App(viewModel: AppViewModel) {
    AshulukTheme {
        val appState = rememberAppState()
        Scaffold(scaffoldState = appState.scaffoldState,
            topBar = {
                AshulukTopBar(
                    owner = appState.viewModelStoreOwner,
                    route = appState.currentRoute,
                    popBack = appState::popBack
                )
            },
            bottomBar = {
                AshulukBottomBar(
                    route = appState.currentRoute,
                    tabs = appState.bottomScreenTabs,
                    showBottomBar = appState.showBottomBar(),
                    onClick = appState::navigate
                )
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = it,
                    modifier = Modifier.padding(8.dp),
                    snackbar = { snackbarData ->
                        Snackbar(
                            snackbarData = snackbarData,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                )
            },
            content = { innerPadding ->
                NavHost(
                    navController = appState.navController,
                    modifier = Modifier.padding(innerPadding),
                    startDestination = viewModel.startDestination.value
                ) {
                    ashulukNavGraph(appState)
                }
            }
        )
    }
}

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    snackbarManager: SnackbarManager = SnackbarManager,
    resources: Resources = LocalContext.current.resources,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    viewModelStoreOwner: ViewModelStoreOwner? = LocalViewModelStoreOwner.current,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember {
    AppState(
        navController = navController,
        viewModelStoreOwner = viewModelStoreOwner!!,
        snackbarManager = snackbarManager,
        resources = resources,
        scaffoldState = scaffoldState,
        coroutineScope = coroutineScope
    )
}

