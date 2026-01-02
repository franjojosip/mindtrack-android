package com.fjjukic.mindtrack.feature.dashboard

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.dashboard.navigation.DashboardRoute

fun NavGraphBuilder.dashboardFeature(
    createViewModel: () -> DashboardViewModel
) {
    composable(DashboardRoute.route) {
        DashboardScreen(viewModel = createViewModel())
    }
}