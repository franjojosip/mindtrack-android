package com.fjjukic.mindtrack

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fjjukic.mindtrack.di.MindTrackContainer
import com.fjjukic.mindtrack.navigation.MindTrackNavGraph

@Composable
fun AppRoot(container: MindTrackContainer) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        MindTrackNavGraph(container)
    }
}
