package com.fjjukic.mindtrack.feature.dashboard

import com.fjjukic.mindtrack.domain.mood.MoodEntry
import com.fjjukic.mindtrack.domain.mood.MoodRepository
import com.fjjukic.mindtrack.domain.mood.usecase.ObserveRecentMoodsUseCase
import com.fjjukic.mindtrack.domain.mood.usecase.SaveMoodEntryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertNull

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var repository: FakeMoodRepository
    private lateinit var viewModel: DashboardViewModel

    private val fixedDate = LocalDate.parse("2026-01-02")

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        repository = FakeMoodRepository()

        viewModel = DashboardViewModel(
            observeRecentMoods = ObserveRecentMoodsUseCase(repository),
            saveMoodEntry = SaveMoodEntryUseCase(repository),
            dateProvider = { fixedDate },
            dispatcher = testDispatcher
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `saving mood updates recent list and clears input`() = runTest {
        // Initial state
        val initialState = viewModel.state.value
        assertEquals(emptyList(), initialState.recent)
        assertNull(initialState.todayMood)

        // User selects mood and types note
        viewModel.onEvent(DashboardEvent.MoodSelected(4))
        viewModel.onEvent(DashboardEvent.NoteChanged("Feeling good"))

        // Save
        viewModel.onEvent(DashboardEvent.SaveClicked)

        // run all coroutines (save + flow + ui updates)
        testDispatcher.scheduler.advanceUntilIdle()
        val savedState = viewModel.state.value

        assertEquals(1, savedState.recent.size)

        val saved = savedState.recent.first()
        assertEquals("Fri, Jan 2", saved.formattedDate)
        assertEquals(4, saved.value)
        assertEquals("Feeling good", saved.note)

        // Input should be cleared
        assertNull(savedState.selectedMood)
        assertEquals("", savedState.note)
    }

    // --- Fake repository used by the ViewModel ---
    private class FakeMoodRepository : MoodRepository {

        private val data = MutableStateFlow<Map<LocalDate, MoodEntry>>(emptyMap())

        override fun observeRecent(limit: Int): Flow<List<MoodEntry>> =
            data.map { map ->
                map.values.sortedByDescending { it.date }.take(limit)
            }

        override suspend fun upsert(entry: MoodEntry) {
            data.value += (entry.date to entry)
        }

        override suspend fun getForDate(date: LocalDate): MoodEntry? {
            return data.value[date]
        }
    }
}
