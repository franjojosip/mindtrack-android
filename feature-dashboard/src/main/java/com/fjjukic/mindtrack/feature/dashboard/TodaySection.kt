package com.fjjukic.mindtrack.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodaySection(
    state: DashboardUiState,
    onEvent: (DashboardEvent) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Today", style = MaterialTheme.typography.headlineSmall)

        MoodSelector(
            selected = state.selectedMood,
            onSelect = { onEvent(DashboardEvent.MoodSelected(it)) }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.note,
            onValueChange = { onEvent(DashboardEvent.NoteChanged(it)) },
            label = { Text("Note (optional)") }
        )

        SaveButton(
            enabled = state.selectedMood != null && !state.isSaving,
            isSaving = state.isSaving,
            onClick = { onEvent(DashboardEvent.SaveClicked) }
        )
    }
}
