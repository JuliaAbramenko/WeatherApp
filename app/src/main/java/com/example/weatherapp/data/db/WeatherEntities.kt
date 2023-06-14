package com.example.weatherapp.data.db

import androidx.room.Entity
import java.time.LocalDate

@Entity(tableName = "daily_weather_db", primaryKeys = ["timestamp", "longitude", "latitude"])
data class DailyWeatherEntity(
    val timestamp: String,
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
    val timestamp: String,
    val longitude: Double,
    val latitude: Double,
    val currentTemperature: Double,
    val currentWindSpeed: Double,
    val currentWeatherCode: Int
)
