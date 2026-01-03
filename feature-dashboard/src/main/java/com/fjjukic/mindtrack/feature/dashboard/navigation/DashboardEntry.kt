package com.fjjukic.mindtrack.feature.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.dashboard.DashboardScreen
import com.fjjukic.mindtrack.feature.dashboard.DashboardViewModel

fun NavGraphBuilder.dashboardFeature(
    createViewModel: () -> DashboardViewModel
) {
    composable(DashboardRoute.route) {
        DashboardScreen(viewModel = createViewModel())
    }
}