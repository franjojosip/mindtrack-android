package com.fjjukic.mindtrack.di

import com.fjjukic.mindtrack.data.mood.InMemoryMoodRepository
import com.fjjukic.mindtrack.domain.mood.MoodRepository
import com.fjjukic.mindtrack.domain.mood.usecase.ObserveRecentMoodsUseCase
import com.fjjukic.mindtrack.domain.mood.usecase.SaveMoodEntryUseCase
import com.fjjukic.mindtrack.domain.time.DateProvider
import java.time.LocalDate

class MindTrackContainer {

    // Core singletons
    private val dateProvider: DateProvider = DateProvider { LocalDate.now() }

    // Data layer
    private val moodRepository: MoodRepository = InMemoryMoodRepository()

    // Domain use cases
    val observeRecentMoodsUseCase = ObserveRecentMoodsUseCase(moodRepository)
    val saveMoodEntryUseCase = SaveMoodEntryUseCase(moodRepository)

    // Expose dateProvider for VM factory
    fun dateProvider(): DateProvider = dateProvider
}
