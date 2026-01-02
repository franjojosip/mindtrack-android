package com.fjjukic.mindtrack.domain.mood.usecase

import com.fjjukic.mindtrack.domain.mood.MoodEntry
import com.fjjukic.mindtrack.domain.mood.MoodRepository
import kotlinx.coroutines.flow.Flow

class ObserveRecentMoodsUseCase(
    private val repository: MoodRepository
) {
    operator fun invoke(limit: Int = 7): Flow<List<MoodEntry>> =
        repository.observeRecent(limit)
}