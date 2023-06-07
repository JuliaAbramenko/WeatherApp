package com.example.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.data.model.WeatherModel

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: List<WeatherEntity>)

    @Delete
    suspend fun clearDB()

    @Query("SELECT * FROM weather_db WHERE dailyTime=:today")
    suspend fun getWeatherToday(today: String): WeatherEntity

    // TODO: find way to execute this query properly and as intended
    @Query("SELECT * FROM weather_db WHERE dailyTime=:today")
    suspend fun getWeather10Days(today: String, forecastDays: Int): List<WeatherEntity>
}