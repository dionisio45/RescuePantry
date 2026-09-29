package org.rescuepantry.app.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.rescuepantry.app.ui.navigation.components.CompactNavigationBar
import org.rescuepantry.app.ui.navigation.components.ExpandedNavigationBar
import org.rescuepantry.app.ui.navigation.components.MediumNavigationBar
import org.rescuepantry.app.ui.navigation.components.NavigationItem
import org.rescuepantry.app.ui.navigation.components.navigationItemsList
import org.rescuepantry.app.ui.navigation.components.topLevelRoutes

/**
 * Entry point of the navigation menu.
 *
 * No Koin in this starter: the [NavigationViewModel] is created with the
 * stock `viewModel()` factory. Layout adapts to window width without extra
 * dependencies (plain [BoxWithConstraints] breakpoints instead of the
 * material3-window-size-class artifact Chemistry uses):
 * - Compact (< 600dp): bottom bar.
 * - Medium (600-840dp): narrow navigation rail.
 * - Expanded (> 840dp): wide navigation rail with labels.
 *
 * The menu is only shown on top-level routes ([topLevelRoutes]).
 */
@Composable
fun NavigationScreenRoot(
    navigationViewModel: NavigationViewModel = viewModel(),
) {
    val uiState by navigationViewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val layoutType = remember(maxWidth) {
            when {
                maxWidth < 600.dp -> NavigationLayout.Compact
                maxWidth < 840.dp -> NavigationLayout.Medium
                else -> NavigationLayout.Expanded
            }
        }
        NavigationScaffold(
            layoutType = layoutType,
            navController = navController,
            uiState = uiState,
        )
    }
}

enum class NavigationLayout {
    Compact,
    Medium,
    Expanded
}

@Composable
fun NavigationScaffold(
    layoutType: NavigationLayout,
    navController: NavHostController,
    uiState: NavigationUiState,
) {
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = getCurrentRoute(backStack?.destination?.route)
    val showMenu = currentRoute in topLevelRoutes

    fun onItemClick(item: NavigationItem) {
        navController.navigate(item.route) {
            popUpTo(Route.Home) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AnimatedVisibility(
                visible = layoutType == NavigationLayout.Compact && showMenu,
                enter = fadeIn(animationSpec = tween(700)) +
                    slideInVertically(
                        initialOffsetY = { it },
                        animationSpec = tween(700)
                    ),
                exit = fadeOut(animationSpec = tween(500)) +
                    slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(500)
                    )
            ) {
                CompactNavigationBar(
                    items = navigationItemsList,
                    currentRoute = currentRoute,
                    uiState = uiState,
                    onItemClick = ::onItemClick
                )
            }
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AnimatedVisibility(
                visible = layoutType == NavigationLayout.Medium && showMenu,
                enter = fadeIn(animationSpec = tween(700)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                MediumNavigationBar(
                    items = navigationItemsList,
                    uiState = uiState,
                    currentRoute = currentRoute,
                    onItemClick = ::onItemClick
                )
            }

            AnimatedVisibility(
                visible = layoutType == NavigationLayout.Expanded && showMenu,
                enter = fadeIn(animationSpec = tween(700)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                ExpandedNavigationBar(
                    items = navigationItemsList,
                    uiState = uiState,
                    currentRoute = currentRoute,
                    onItemClick = ::onItemClick
                )
            }

            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = Route.Home
                ) {
                    rescuePantryNavGraph()
                }
            }
        }
    }
}

/**
 * Maps the Nav2 destination route string (qualified class name of the
 * `@Serializable` destination) back to its [Route]. Returns null for
 * non-menu destinations so the bars stay hidden there.
 */
fun getCurrentRoute(route: String?): Route? {
    return when (route?.substringBefore("?")) {
        Route.Home::class.qualifiedName -> Route.Home
        Route.Pantry::class.qualifiedName -> Route.Pantry
        Route.Shopping::class.qualifiedName -> Route.Shopping
        Route.Recipes::class.qualifiedName -> Route.Recipes
        Route.Settings::class.qualifiedName -> Route.Settings
        else -> null
    }
}
