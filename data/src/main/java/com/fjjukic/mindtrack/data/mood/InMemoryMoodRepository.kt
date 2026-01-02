package com.fjjukic.mindtrack.data.mood

import com.fjjukic.mindtrack.domain.mood.MoodEntry
import com.fjjukic.mindtrack.domain.mood.MoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class InMemoryMoodRepository : MoodRepository {

    // Store by date so "upsert" replaces existing entry for that date
    private val storage = MutableStateFlow<Map<LocalDate, MoodEntry>>(emptyMap())

    override fun observeRecent(limit: Int): Flow<List<MoodEntry>> {
        return storage.map { map ->
            map.values
                .sortedByDescending { it.date }
                .take(limit)
        }
    }

    override suspend fun upsert(entry: MoodEntry) {
        storage.value += (entry.date to entry)
    }

    override suspend fun getForDate(date: LocalDate): MoodEntry? {
        return storage.value[date]
    }
}
