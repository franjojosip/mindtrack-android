package com.fjjukic.mindtrack.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fjjukic.mindtrack.navigation.TopLevelDestination

@Composable
fun MindTrackBottomBar(
    navController: NavHostController,
    destinations: List<TopLevelDestination>
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavigationBar {
        destinations.forEach { destination ->
            val selected = currentRoute == destination.route.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(destination.route.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(destination.icon, contentDescription = destination.label)
                },
                label = {
                    Text(destination.label)
                }
            )
        }
    }
}
