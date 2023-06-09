package com.example.weatherapp.data.apimodel

import com.google.gson.annotations.SerializedName

data class DailyUnits(
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: String,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("weathercode")
    val weatherCode: String
)