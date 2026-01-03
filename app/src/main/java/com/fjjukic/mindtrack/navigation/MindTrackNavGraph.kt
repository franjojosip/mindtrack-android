package com.fjjukic.mindtrack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fjjukic.mindtrack.di.MindTrackContainer
import com.fjjukic.mindtrack.feature.auth.navigation.authFeature
import com.fjjukic.mindtrack.feature.dashboard.DashboardViewModel
import com.fjjukic.mindtrack.feature.dashboard.navigation.DashboardRoute
import com.fjjukic.mindtrack.feature.dashboard.navigation.dashboardFeature
import com.fjjukic.mindtrack.feature.habits.navigation.habitsFeature
import com.fjjukic.mindtrack.feature.health.navigation.healthFeature
import com.fjjukic.mindtrack.feature.settings.navigation.settingsFeature

@Composable
fun MindTrackNavGraph(
    navController: NavHostController,
    container: MindTrackContainer,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DashboardRoute.route,
        modifier = modifier
    ) {
        authFeature()
        dashboardFeature(
            createViewModel = {
                DashboardViewModel(
                    observeRecentMoods = container.observeRecentMoodsUseCase,
                    saveMoodEntry = container.saveMoodEntryUseCase,
                    dateProvider = container.dateProvider()
                )
            }
        )
        habitsFeature()
        healthFeature()
        settingsFeature()
    }
}
