package com.delegateadapters.base

import com.delegateadapters.base.model.MoveViewModel
import java.text.SimpleDateFormat
import java.util.*

object DataUtils {
    val currentDate = Date()
    fun getDate(i: Int): String {
        // Текущее время
        MoveViewModel.TimeInterval.DAY
        val currentDate = Date()
// Форматирование времени как "день.месяц.год"
        if (i == 0) {
            val dateDay = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(currentDate)
            return dateDay
        } else {
            // Форматирование времени как "часы:минуты:секунды"
            val dataTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(currentDate)
            return dataTime
        }
    }
}