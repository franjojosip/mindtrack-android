package com.fjjukic.mindtrack.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ShowChart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Task
import androidx.compose.ui.graphics.vector.ImageVector
import com.fjjukic.mindtrack.core.ui.navigation.MindTrackRoute
import com.fjjukic.mindtrack.feature.dashboard.navigation.DashboardRoute
import com.fjjukic.mindtrack.feature.habits.navigation.HabitsRoute
import com.fjjukic.mindtrack.feature.health.navigation.HealthRoute
import com.fjjukic.mindtrack.feature.settings.navigation.SettingsRoute

sealed class TopLevelDestination(
    val route: MindTrackRoute,
    val label: String,
    val icon: ImageVector
) {
    data object Dashboard : TopLevelDestination(
        DashboardRoute, "Dashboard", Icons.AutoMirrored.Filled.ShowChart
    )

    data object Habits : TopLevelDestination(
        HabitsRoute, "Habits", Icons.Default.Task
    )

    data object Health : TopLevelDestination(
        HealthRoute, "Health", Icons.Default.Favorite
    )

    data object Settings : TopLevelDestination(
        SettingsRoute, "Settings", Icons.Default.Settings
    )
}
