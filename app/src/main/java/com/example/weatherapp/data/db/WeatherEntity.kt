package com.example.weatherapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.data.model.CurrentWeather
import com.example.weatherapp.data.model.Daily

@Entity
data class WeatherEntity(
    @PrimaryKey
    val timestamp: String,
    val longitude: Double,
    val latitude: Double,
    val currentWeather: CurrentWeather,
    val daily: Daily
)
