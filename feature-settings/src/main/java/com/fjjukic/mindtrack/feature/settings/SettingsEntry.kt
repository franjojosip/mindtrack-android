package com.fjjukic.mindtrack.feature.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.settings.navigation.SettingsRoute

fun NavGraphBuilder.settingsFeature() {
    composable(SettingsRoute.route) {
        SettingsScreen()
    }
}