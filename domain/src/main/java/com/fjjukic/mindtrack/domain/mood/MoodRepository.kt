package com.fjjukic.mindtrack.domain.mood

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface MoodRepository {
    fun observeRecent(limit: Int): Flow<List<MoodEntry>>
    suspend fun upsert(entry: MoodEntry)
    suspend fun getForDate(date: LocalDate): MoodEntry?
}