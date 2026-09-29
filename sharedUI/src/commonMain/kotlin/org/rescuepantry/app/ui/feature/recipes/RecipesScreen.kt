package org.rescuepantry.app.ui.feature.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Placeholder for the Recipes destination.
 * Mirrors the v2 mockup "Cook" tab (restaurant icon): rescue expiring
 * food by cooking it. TODO: replace with the real recipes content.
 */
@Composable
fun RecipesScreen() {
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Recipes",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
