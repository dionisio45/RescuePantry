package org.rescuepantry.app.ui.navigation.components

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.rescuepantry.app.ui.navigation.NavigationUiState
import org.rescuepantry.app.ui.navigation.Route

/**
 * Bottom navigation bar for compact screens (phones).
 * Adapted from Chemistry `CompactNavigationBar`, icons swapped to Material.
 */
@Composable
fun CompactNavigationBar(
    currentRoute: Route?,
    items: List<NavigationItem>,
    uiState: NavigationUiState,
    onItemClick: (NavigationItem) -> Unit,
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        tonalElevation = 0.dp,
        windowInsets = NavigationBarDefaults.windowInsets.only(
            WindowInsetsSides.Bottom
        )
    ) {
        items.forEach { navigationItem ->
            val isSelected = navigationItem.route == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) {
                            navigationItem.selectedIcon
                        } else {
                            navigationItem.unselectedIcon
                        },
                        contentDescription = uiState.string(navigationItem.titleKey)
                    )
                },
                label = {
                    Text(text = uiState.string(navigationItem.titleKey))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onSurface,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                )
            )
        }
    }
}
