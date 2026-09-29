package org.rescuepantry.app.ui.navigation.components

import androidx.compose.ui.graphics.vector.ImageVector
import org.rescuepantry.app.ui.navigation.Route

/**
 * Single entry of the navigation menu.
 *
 * Unlike Chemistry (which uses generated drawable resources), the starter
 * uses Material [ImageVector] icons so no drawable assets are needed.
 */
data class NavigationItem(
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val titleKey: String,
    val route: Route,
)
