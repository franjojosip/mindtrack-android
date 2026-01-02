package com.fjjukic.mindtrack.domain.time

import java.time.LocalDate

fun interface DateProvider {
    fun today(): LocalDate
}