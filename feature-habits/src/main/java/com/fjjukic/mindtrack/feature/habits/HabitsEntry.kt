package com.fjjukic.mindtrack.feature.habits

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fjjukic.mindtrack.feature.habits.navigation.HabitsRoute

fun NavGraphBuilder.habitsFeature() {
    composable(HabitsRoute.route) {
        HabitsScreen()
    }
}