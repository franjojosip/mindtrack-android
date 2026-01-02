package com.fjjukic.mindtrack.data.mood

import com.fjjukic.mindtrack.domain.mood.MoodEntry
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class InMemoryMoodRepositoryTest {

    @Test
    fun `upsert replaces by date`() = runTest {
        val repo = InMemoryMoodRepository()
        val d = LocalDate.parse("2026-01-02")

        repo.upsert(MoodEntry(d, 2, "meh"))
        repo.upsert(MoodEntry(d, 5, "great"))

        val result = repo.getForDate(d)
        assertEquals(5, result?.value)
        assertEquals("great", result?.note)
    }
}
