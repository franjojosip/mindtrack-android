package com.fjjukic.mindtrack.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjjukic.mindtrack.domain.mood.MoodEntry
import com.fjjukic.mindtrack.domain.mood.usecase.ObserveRecentMoodsUseCase
import com.fjjukic.mindtrack.domain.mood.usecase.SaveMoodEntryUseCase
import com.fjjukic.mindtrack.domain.time.DateProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

class DashboardViewModel(
    private val observeRecentMoods: ObserveRecentMoodsUseCase,
    private val saveMoodEntry: SaveMoodEntryUseCase,
    private val dateProvider: DateProvider,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {
    private val formatter = DateTimeFormatter.ofPattern("EEE, MMM d")

    private val _state = MutableStateFlow(DashboardUiState())
    val state: StateFlow<DashboardUiState> = _state

    init {
        viewModelScope.launch(dispatcher) {
            observeRecentMoods().collect { entries ->
                val uiModels = entries.map { it.toUiModel(formatter) }
                _state.update { it.copy(recent = uiModels) }
            }
        }
    }

    fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.MoodSelected -> {
                _state.update { it.copy(selectedMood = event.value) }
            }

            is DashboardEvent.NoteChanged -> {
                _state.update { it.copy(note = event.value) }
            }

            DashboardEvent.SaveClicked -> save()
            DashboardEvent.DismissError -> _state.update { it.copy(error = null) }
        }
    }

    private fun save() {
        val moodValue = _state.value.selectedMood
        if (moodValue == null) {
            _state.update { it.copy(error = "Pick a mood first.") }
            return
        }

        viewModelScope.launch(dispatcher) {
            _state.update { it.copy(isSaving = true, error = null) }

            try {
                val entry = MoodEntry(
                    date = dateProvider.today(),
                    value = moodValue,
                    note = _state.value.note.takeIf { it.isNotBlank() }
                )
                saveMoodEntry(entry)

                _state.update { it.copy(isSaving = false, selectedMood = null, note = "") }
            } catch (t: Throwable) {
                _state.update { it.copy(isSaving = false, error = t.message ?: "Unknown error") }
            }
        }
    }

    private fun MoodEntry.toUiModel(formatter: DateTimeFormatter): MoodUi =
        MoodUi(
            formattedDate = date.format(formatter),
            value = value,
            note = note
        )
}
