package com.fjjukic.mindtrack.domain.mood

import com.fjjukic.mindtrack.domain.mood.usecase.SaveMoodEntryUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import java.time.LocalDate
import kotlin.test.Test

private class FakeMoodRepository : MoodRepository {
    val saved = mutableListOf<MoodEntry>()

    override suspend fun upsert(entry: MoodEntry) {
        saved += entry
    }

    override fun observeRecent(limit: Int) = flowOf(saved)
    override suspend fun getForDate(date: LocalDate) =
        saved.find { it.date == date }
}

class SaveMoodEntryUseCaseTest {
    @Test
    fun `saving a mood stores it in repository`() = runTest {
        val repo = FakeMoodRepository()
        val save = SaveMoodEntryUseCase(repo)

        val entry = MoodEntry(
            date = LocalDate.now(),
            value = 4,
            note = "Feeling good"
        )

        save(entry)

        assertEquals(entry, repo.saved.first())
    }
}