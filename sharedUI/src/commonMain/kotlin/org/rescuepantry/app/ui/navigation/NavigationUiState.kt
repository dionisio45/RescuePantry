package org.rescuepantry.app.ui.navigation

/**
 * UI state for the navigation scaffold.
 *
 * Simplified starter version: no coupling to Settings use cases yet.
 *
 * TODO: wire [themeMode] to the app theme settings and [strings] to the
 *  i18n catalogue once those layers exist. Until then [string] returns the
 *  key itself so labels still render something readable.
 */
data class NavigationUiState(
    val isReady: Boolean = true,
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val strings: Map<String, String> = emptyMap(),
) {
    fun string(key: String): String = strings[key] ?: key
}

enum class ThemeMode {
    LIGHT,
    DARK,
    SYSTEM
}
