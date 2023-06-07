package com.example.weatherapp.data.datasourceimpl

import com.example.weatherapp.data.datasource.WeatherLocalDataSource
import com.example.weatherapp.data.db.WeatherDao
import com.example.weatherapp.data.db.WeatherEntity

class WeatherLocalDataSourceImpl(private val weatherDao: WeatherDao) : WeatherLocalDataSource{
    override suspend fun saveWeatherToDB(weather: List<WeatherEntity>) {
        TODO("Not yet implemented")
        //CoroutineScope(Dispatchers.IO).launch {}
    }

    override suspend fun clearDB() {
        TODO("Not yet implemented")
        //CoroutineScope(Dispatchers.IO).launch {}
    }

    override suspend fun getWeatherToday(today: String): WeatherEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getWeather10Days(today: String, forecastDays: Int): List<WeatherEntity> {
        TODO("Not yet implemented")
    }
}