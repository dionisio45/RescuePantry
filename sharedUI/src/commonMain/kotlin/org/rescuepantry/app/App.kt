package org.rescuepantry.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}
) {
    RescuePantryApp(onThemeChanged = onThemeChanged)
}
