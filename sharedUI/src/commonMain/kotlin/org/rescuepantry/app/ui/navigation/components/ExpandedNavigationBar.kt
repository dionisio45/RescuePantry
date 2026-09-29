package org.rescuepantry.app.ui.navigation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.rescuepantry.app.ui.navigation.NavigationUiState
import org.rescuepantry.app.ui.navigation.Route

/**
 * Wide navigation rail with icon + label rows for expanded screens.
 * Adapted from Chemistry `ExpandedNavigationBar`.
 */
@Composable
fun ExpandedNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>,
    uiState: NavigationUiState,
    currentRoute: Route?,
    onItemClick: (NavigationItem) -> Unit,
    expandedWidth: Dp = 200.dp,
) {
    Row(modifier = modifier) {
        NavigationRail(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            modifier = Modifier.fillMaxHeight().width(expandedWidth),
            header = { },
            windowInsets = WindowInsets(0)
        ) {
            items.forEach { navigationItem ->
                val isSelected = navigationItem.route == currentRoute
                NavigationItemView(
                    navigationItem = navigationItem,
                    isSelected = isSelected,
                    onItemClick = { onItemClick(navigationItem) },
                    uiState = uiState
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

@Composable
private fun NavigationItemView(
    navigationItem: NavigationItem,
    isSelected: Boolean,
    onItemClick: () -> Unit,
    uiState: NavigationUiState,
) {
    NavigationRailItem(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, end = 20.dp),
        selected = isSelected,
        onClick = onItemClick,
        icon = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = if (isSelected) {
                        navigationItem.selectedIcon
                    } else {
                        navigationItem.unselectedIcon
                    },
                    contentDescription = uiState.string(navigationItem.titleKey)
                )

                Spacer(Modifier.width(12.dp))

                Text(
                    text = uiState.string(navigationItem.titleKey),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1
                )
            }
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
