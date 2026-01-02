package com.fjjukic.mindtrack.feature.dashboard

sealed interface DashboardEvent {
    data class MoodSelected(val value: Int) : DashboardEvent
    data class NoteChanged(val value: String) : DashboardEvent
    data object SaveClicked : DashboardEvent
    data object DismissError : DashboardEvent
}