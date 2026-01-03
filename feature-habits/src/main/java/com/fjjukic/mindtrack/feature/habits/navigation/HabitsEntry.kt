package com.fjjukic.mindtrack.feature.habits.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.habits.HabitsScreen

fun NavGraphBuilder.habitsFeature() {
    composable(HabitsRoute.route) {
        HabitsScreen()
    }
}