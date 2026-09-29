package org.rescuepantry.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.rescuepantry.app.ui.navigation.NavigationScreenRoot
import org.rescuepantry.app.ui.theme.AppTheme

/**
 * App entry point (equivalent of Chemistry `ChemistryApp`).
 *
 * Wraps the navigation menu in the app theme. Simplified starter version:
 * theme follows the system / [AppTheme] toggle, no ViewModel-driven
 * ThemeMode yet.
 */
@Composable
fun RescuePantryApp(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {},
) {
    AppTheme(onThemeChanged) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavigationScreenRoot()
        }
    }
}
