package org.rescuepantry.app.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.rescuepantry.app.ui.feature.home.HomeScreen
import org.rescuepantry.app.ui.feature.pantry.PantryScreen
import org.rescuepantry.app.ui.feature.recipes.RecipesScreen
import org.rescuepantry.app.ui.feature.settings.SettingsScreen
import org.rescuepantry.app.ui.feature.shopping.ShoppingScreen

// NAVIGATION LIBRARY DECISION: Navigation Compose 2 (Nav2, typed routes).
// Chemistry uses org.jetbrains.androidx.navigation:navigation-compose:2.9.2
// with the `composable<Route.X>` typed API and that menu works well, so this
// starter ports the same pattern instead of the declared-but-unused Nav3
// alphas. Do NOT mix Nav2 and Nav3 in the same NavHost.

/**
 * Registers the 5 top-level destinations. Add new `composable<Route.X>`
 * entries here as features grow.
 */
fun NavGraphBuilder.rescuePantryNavGraph() {
    composable<Route.Home>(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        HomeScreen()
    }

    composable<Route.Pantry>(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        PantryScreen()
    }

    composable<Route.Shopping>(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        ShoppingScreen()
    }

    composable<Route.Recipes>(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        RecipesScreen()
    }

    composable<Route.Settings>(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        SettingsScreen()
    }
}
