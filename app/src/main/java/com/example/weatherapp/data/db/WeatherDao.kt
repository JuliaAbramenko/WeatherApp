package com.example.weatherapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.apimodel.CurrentWeather

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyWeather(weather: List<DailyWeatherEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentWeather(weather: CurrentWeatherEntity)

    @Query("DELETE FROM current_weather_db")
    suspend fun clearCurrentWeatherDB()

    @Query("DELETE FROM daily_weather_db")
    suspend fun clearDailyWeatherDB()

    @Query("SELECT * FROM current_weather_db")
    suspend fun getCurrentWeather() : CurrentWeatherEntity

    @Query("SELECT * FROM daily_weather_db WHERE dailyTime=:today")
    suspend fun getWeatherToday(today: Long): DailyWeatherEntity

    @Query("SELECT * FROM daily_weather_db WHERE dailyTime >= :startDay AND dailyTime <= :untilDate ")
    suspend fun getWeather10Days(startDay: Long, untilDate: Long): List<DailyWeatherEntity>
}