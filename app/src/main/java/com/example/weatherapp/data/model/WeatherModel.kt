package com.example.weatherapp.data.model

import com.example.weatherapp.data.enums.DailyEnum
import com.example.weatherapp.data.enums.HourlyEnum

data class WeatherModel(
    val current_weather: CurrentWeather,
    val daily: DailyEnum,
    val daily_units: DailyUnits,
    val elevation: Double,
    val generationtime_ms: Double,
    val hourly: HourlyEnum,
    val hourly_units: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)