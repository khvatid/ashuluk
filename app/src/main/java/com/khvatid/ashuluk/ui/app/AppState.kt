package com.khvatid.ashuluk.ui.app

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.khvatid.ashuluk.domain.util.ParentDestination
import com.khvatid.ashuluk.ui.common.components.BottomTabImp
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarManager
import com.khvatid.ashuluk.ui.common.snackbar.SnackbarMessage.Companion.toMessage
import com.khvatid.ashuluk.ui.navigation.UiRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch


@Stable
class AppState(
    val navController: NavHostController,
    val snackbarHostState: androidx.compose.material3.SnackbarHostState,
    val viewModelStoreOwner: ViewModelStoreOwner,
    private val snackbarManager: SnackbarManager,
    private val resources: Resources,
    private val coroutineScope: CoroutineScope,
) {
    init {
        coroutineScope.launch {
            snackbarManager.messages.filterNotNull().collect {
                val text = it.toMessage(resources = resources)
                snackbarHostState.showSnackbar(text)
            }
        }
    }

    // -------------------- Navigation block -------------------------
    val currentRoute: String?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route

    private val route: String?
        get() = navController.currentDestination?.route


    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun popBack() {
        navController.popBackStack()
    }

    fun clearAndNavigate(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) {
                inclusive = true
            }
        }
    }
    // -------------------- Global UI --------------------------------

    val bottomScreenTabs = BottomTabImp.tabs

    fun showBottomBar(): Boolean = when (route) {
        UiRoutes.KANBAN -> true
        UiRoutes.SETTINGS -> true
        UiRoutes.MAIN -> true
        else -> false
    }

}

data class UiAppState(
    val startDestination: String = ParentDestination.AUTH
)