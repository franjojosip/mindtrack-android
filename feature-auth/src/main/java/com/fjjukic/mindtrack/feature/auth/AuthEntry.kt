package com.fjjukic.mindtrack.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.auth.navigation.AuthRoute

fun NavGraphBuilder.authFeature() {
    composable(AuthRoute.route) {
        AuthScreen()
    }
}