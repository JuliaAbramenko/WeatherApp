package com.example.weatherapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.Daily

@Entity(tableName = "weather_db")
data class WeatherEntity(
    @PrimaryKey
    val timestamp: String,
    val longitude: Double,
    val latitude: Double,
    val currentTemperature: Double,
    val currentWindSpeed: Double,
    val currentWeatherCode: Int,
    val dailyTime: String,
    val dailyWeatherCode: Int,
    val dailyTemperature2mMax: Double,
    val dailyTemperature2mMin: Double
)
