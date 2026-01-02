package com.fjjukic.mindtrack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fjjukic.mindtrack.feature.auth.authFeature
import com.fjjukic.mindtrack.feature.dashboard.dashboardFeature
import com.fjjukic.mindtrack.feature.dashboard.navigation.DashboardRoute
import com.fjjukic.mindtrack.feature.habits.habitsFeature
import com.fjjukic.mindtrack.feature.health.healthFeature
import com.fjjukic.mindtrack.feature.settings.settingsFeature

@Composable
fun MindTrackNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DashboardRoute.route
    ) {
        authFeature()
        dashboardFeature()
        habitsFeature()
        healthFeature()
        settingsFeature()
    }
}
