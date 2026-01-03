package com.fjjukic.mindtrack.feature.settings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.settings.SettingsScreen

fun NavGraphBuilder.settingsFeature() {
    composable(SettingsRoute.route) {
        SettingsScreen()
    }
}