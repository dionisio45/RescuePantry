package org.rescuepantry.app.ui.navigation

import kotlinx.serialization.Serializable

/**
 * Top-level destinations for the RescuePantry starter menu.
 *
 * Direct port of the Chemistry `Route` pattern (typed destinations with
 * `@Serializable` data objects), simplified to the 5 pantry sections.
 * New destinations are added here as new `data object` entries.
 */
sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Pantry : Route

    @Serializable
    data object Shopping : Route

    @Serializable
    data object Recipes : Route

    @Serializable
    data object Settings : Route
}
