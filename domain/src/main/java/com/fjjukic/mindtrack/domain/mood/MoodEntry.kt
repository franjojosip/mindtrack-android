package com.fjjukic.mindtrack.domain.mood

import java.time.LocalDate

data class MoodEntry(
    val date: LocalDate,
    val value: Int,          // 1..5
    val note: String? = null
)
