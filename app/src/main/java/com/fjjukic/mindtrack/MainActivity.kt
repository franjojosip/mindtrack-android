package com.fjjukic.mindtrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fjjukic.mindtrack.di.MindTrackContainer
import com.fjjukic.mindtrack.ui.theme.MindTrackTheme

class MainActivity : ComponentActivity() {

    private val container = MindTrackContainer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MindTrackTheme {
                AppRoot(container = container)
            }
        }
    }
}