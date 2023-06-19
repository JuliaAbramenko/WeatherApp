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

    suspend fun getWeatherToday(today: Long): DailyWeatherEntity

    suspend fun getWeather10Days(startDay: Long, untilDate: Long): List<DailyWeatherEntity>
}