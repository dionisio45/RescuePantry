package org.rescuepantry.app.ui.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Holds the [NavigationUiState] for the navigation scaffold.
 *
 * Starter version with no injected dependencies (no Koin in RescuePantry,
 * no Settings use cases yet). Exposes a plain [StateFlow] so screens can
 * collect it with `collectAsStateWithLifecycle()`.
 *
 * TODO: combine app theme / language / translations flows here once the
 *  settings domain layer exists (see Chemistry NavigationViewModel).
 */
class NavigationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NavigationUiState())
    val uiState: StateFlow<NavigationUiState> = _uiState.asStateFlow()
}
