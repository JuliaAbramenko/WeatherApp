package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.apimodel.CurrentWeather
import com.example.weatherapp.data.db.CurrentWeatherEntity

interface WeatherLocalDataSource {
    suspend fun insertDailyWeather(weather: List<DailyWeatherEntity>)

    suspend fun insertCurrentWeather(currentWeather: CurrentWeatherEntity)

    suspend fun clearCurrentWeatherDB()

    suspend fun clearDailyWeatherDB()

    suspend fun getCurrentWeather() : CurrentWeatherEntity

    suspend fun getWeatherToday(today: String): DailyWeatherEntity

    suspend fun getWeather10Days(startDay: String, untilDate: String): List<DailyWeatherEntity>
}