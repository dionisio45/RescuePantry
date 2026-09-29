package org.rescuepantry.app.ui.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import org.rescuepantry.app.ui.navigation.Route

/**
 * The 5 top-level menu entries shown in every window size class.
 *
 * NOTE: outlined variants live in `material-icons-extended`. If the
 * extended artifact is not on the classpath, replace the `outlined`
 * references with their `filled` counterparts.
 */
val navigationItemsList = listOf(
    NavigationItem(
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        titleKey = "Home",
        route = Route.Home,
    ),
    NavigationItem(
        unselectedIcon = Icons.Outlined.Kitchen,
        selectedIcon = Icons.Filled.Kitchen,
        titleKey = "Pantry",
        route = Route.Pantry,
    ),
    NavigationItem(
        unselectedIcon = Icons.Outlined.ShoppingCart,
        selectedIcon = Icons.Filled.ShoppingCart,
        titleKey = "Shopping",
        route = Route.Shopping,
    ),
    NavigationItem(
        unselectedIcon = Icons.Outlined.Restaurant,
        selectedIcon = Icons.Filled.Restaurant,
        titleKey = "Recipes",
        route = Route.Recipes,
    ),
    NavigationItem(
        unselectedIcon = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings,
        titleKey = "Settings",
        route = Route.Settings,
    ),
)

/** Routes on which the navigation menu is visible (all top-level ones). */
val topLevelRoutes: Set<Route> = setOf(
    Route.Home,
    Route.Pantry,
    Route.Shopping,
    Route.Recipes,
    Route.Settings,
)
