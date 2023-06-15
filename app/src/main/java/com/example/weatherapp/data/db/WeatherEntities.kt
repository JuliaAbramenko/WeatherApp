package com.example.weatherapp.data.db

import androidx.room.Entity
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "daily_weather_db", primaryKeys = ["timestamp", "longitude", "latitude"])
data class DailyWeatherEntity(
    val timestamp: Long,
    val longitude: Double,
    val latitude: Double,
    val dailyTime: LocalDate,
    val dailyWeatherCode: Int,
    val dailyTemperature2mMax: Double,
    val dailyTemperature2mMin: Double,
    val sunrise: String,
    val sunset: String
)

@Entity (tableName = "current_weather_db", primaryKeys = ["timestamp", "longitude", "latitude"])
data class CurrentWeatherEntity(
    val timestamp: Long,
    val longitude: Double,
    val latitude: Double,
    val currentTemperature: Double,
    val currentWindSpeed: Double,
    val currentWeatherCode: Int,
    val isDay: Boolean
)
