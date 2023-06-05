package com.example.weatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.enums.WindSpeedUnitsEnum
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class CurrentWeather(
    @SerializedName("is_day")
    val isDay: Int,
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("time")
    val time: String,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("weather_direction")
    val windDirection: Double,
    @SerializedName("wind_speed")
    val windSpeed: WindSpeedUnitsEnum
)

