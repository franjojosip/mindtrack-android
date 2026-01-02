package com.fjjukic.mindtrack.feature.dashboard

data class DashboardUiState(
    val todayMood: MoodUi? = null,
    val recent: List<MoodUi> = emptyList(),
    val selectedMood: Int? = null,
    val note: String = "",
    val isSaving: Boolean = false,
    val error: String? = null
)

