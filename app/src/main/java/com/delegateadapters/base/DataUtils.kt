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
        var dataText = ""
        if (i == 0) {
            val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val dateDay = dateFormat.format(currentDate)
            dataText = dateDay
            return dataText
        } else {
            // Форматирование времени как "часы:минуты:секунды"
            val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val dataTime = timeFormat.format(currentDate)
            dataText = dataTime
            return dataText
        }
    }
}