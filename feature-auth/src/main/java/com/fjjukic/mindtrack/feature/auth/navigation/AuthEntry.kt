package com.fjjukic.mindtrack.feature.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.auth.AuthScreen

fun NavGraphBuilder.authFeature() {
    composable(AuthRoute.route) {
        AuthScreen()
    }
}