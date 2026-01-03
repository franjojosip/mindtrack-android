package com.fjjukic.mindtrack.feature.health.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.health.HealthScreen

fun NavGraphBuilder.healthFeature() {
    composable(HealthRoute.route) {
        HealthScreen()
    }
}