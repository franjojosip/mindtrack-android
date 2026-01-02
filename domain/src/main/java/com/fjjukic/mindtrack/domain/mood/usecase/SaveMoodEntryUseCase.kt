package com.fjjukic.mindtrack.domain.mood.usecase

import com.fjjukic.mindtrack.domain.mood.MoodEntry
import com.fjjukic.mindtrack.domain.mood.MoodRepository

class SaveMoodEntryUseCase(
    private val repository: MoodRepository
) {
    suspend operator fun invoke(entry: MoodEntry) {
        require(entry.value in 1..5) { "Mood value must be between 1 and 5." }
        repository.upsert(entry)
    }
}