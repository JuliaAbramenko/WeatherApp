package com.example.weatherapp.data.db.converter

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

// TODO
class Converters {
    @TypeConverter
    fun fromTimestamp(date: String): LocalDateTime {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        return LocalDateTime.parse(date, pattern)

    }

    @TypeConverter
    fun localDateTimeToString(date: LocalDateTime): String {
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        return date!!.format(pattern)
    }
}