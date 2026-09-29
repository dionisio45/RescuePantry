package org.rescuepantry.app.ui.navigation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.rescuepantry.app.ui.navigation.NavigationUiState
import org.rescuepantry.app.ui.navigation.Route

/**
 * Narrow navigation rail for medium screens (foldables, small tablets).
 * Adapted from Chemistry `MediumNavigationBar`.
 */
@Composable
fun MediumNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>,
    uiState: NavigationUiState,
    currentRoute: Route?,
    onItemClick: (NavigationItem) -> Unit,
    mediumWidth: Dp = 112.dp,
) {
    Row(modifier = modifier) {
        NavigationRail(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            modifier = Modifier
                .fillMaxHeight()
                .width(mediumWidth),
            header = { },
            windowInsets = WindowInsets(0)
        ) {
            items.forEach { navigationItem ->
                val isSelected = navigationItem.route == currentRoute
                NavigationRailItem(
                    modifier = Modifier.padding(vertical = 4.dp),
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
                        Text(
                            text = uiState.string(navigationItem.titleKey),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    },
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        selectedTextColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            }
        }
        VerticalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            thickness = 1.dp,
            modifier = Modifier.fillMaxHeight()
        )
    }
}
