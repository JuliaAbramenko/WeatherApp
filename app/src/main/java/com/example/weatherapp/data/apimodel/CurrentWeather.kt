package com.example.weatherapp.data.apimodel

import com.example.weatherapp.data.enums.WindSpeedUnitsEnum
import com.google.gson.annotations.SerializedName

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
    val windSpeed: Double
)

