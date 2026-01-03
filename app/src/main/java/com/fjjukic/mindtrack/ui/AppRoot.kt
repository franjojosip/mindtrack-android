package com.fjjukic.mindtrack.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.fjjukic.mindtrack.di.MindTrackContainer
import com.fjjukic.mindtrack.navigation.MindTrackNavGraph
import com.fjjukic.mindtrack.navigation.TopLevelDestination

@Composable
fun AppRoot(container: MindTrackContainer) {
    val navController = rememberNavController()

    val topLevelDestinations = listOf(
        TopLevelDestination.Dashboard,
        TopLevelDestination.Habits,
        TopLevelDestination.Health,
        TopLevelDestination.Settings
    )

    Scaffold(
        bottomBar = {
            MindTrackBottomBar(
                navController = navController,
                destinations = topLevelDestinations
            )
        }
    ) { padding ->
        MindTrackNavGraph(
            navController = navController,
            container = container,
            modifier = Modifier.padding(padding)
        )
    }
}