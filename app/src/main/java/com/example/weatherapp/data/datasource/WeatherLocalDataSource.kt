package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.db.WeatherEntity

interface WeatherLocalDataSource {
    suspend fun saveWeatherToDB(weather: List<WeatherEntity>)

    suspend fun clearDB()

    suspend fun getWeatherToday(today: String): WeatherEntity

    suspend fun getWeather10Days(today: String, forecastDays: Int): List<WeatherEntity>
}