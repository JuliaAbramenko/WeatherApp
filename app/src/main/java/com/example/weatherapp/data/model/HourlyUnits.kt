package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class HourlyUnits(
    @SerializedName("cloudcover")
    val cloudCover: String,
    @SerializedName("rain")
    val rain: String,
    @SerializedName("showers")
    val showers: String,
    @SerializedName("snowfall")
    val snowfall: String,
    @SerializedName("surface_pressure")
    val surfacePressure: String,
    @SerializedName("temperature_2m")
    val temperature2m: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("uv_index")
    val uvIndex: String,
    @SerializedName("weathercode")
    val weatherCode: String,
    @SerializedName("windspeed_10m")
    val windspeed10m: String
)