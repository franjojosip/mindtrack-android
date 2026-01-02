package com.fjjukic.mindtrack.feature.health

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.health.navigation.HealthRoute

fun NavGraphBuilder.healthFeature() {
    composable(HealthRoute.route) {
        HealthScreen()
    }
}