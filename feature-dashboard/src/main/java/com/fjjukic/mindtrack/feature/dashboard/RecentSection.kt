package com.fjjukic.mindtrack.feature.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RecentSection(
    state: DashboardUiState
) {
    Text("Last 7 days", style = MaterialTheme.typography.titleMedium)

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(state.recent) { entry ->
            ListItem(
                headlineContent = { Text(entry.formattedDate) },
                supportingContent = { Text(entry.note ?: "") },
                trailingContent = { Text("Mood ${entry.value}") }
            )
            Divider()
        }
    }
}
