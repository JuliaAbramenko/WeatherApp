package com.example.weatherapp.data.datasourceimpl

import com.example.weatherapp.data.datasource.WeatherLocalDataSource
import com.example.weatherapp.data.db.WeatherDao
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.apimodel.CurrentWeather
import com.example.weatherapp.data.db.CurrentWeatherEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WeatherLocalDataSourceImpl(private val weatherDao: WeatherDao) : WeatherLocalDataSource{
    override suspend fun insertWeather(weather: List<DailyWeatherEntity>) {
        CoroutineScope(Dispatchers.IO).launch{
            weatherDao.insertWeather(weather)
        }
    }

    override suspend fun clearCurrentWeatherDB() {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDao.clearCurrentWeatherDB()
        }
    }

    override suspend fun clearDailyWeatherDB() {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDao.clearDailyWeatherDB()
        }
    }

    override suspend fun getCurrentWeather(): CurrentWeatherEntity {
        return weatherDao.getCurrentWeather()
    }

    override suspend fun getWeatherToday(today: String): DailyWeatherEntity {
        return weatherDao.getWeatherToday(today)
    }

    override suspend fun getWeather10Days(
        startDay: String,
        untilDate: String
    ): List<DailyWeatherEntity> {
        return weatherDao.getWeather10Days(startDay,untilDate)

    }

}