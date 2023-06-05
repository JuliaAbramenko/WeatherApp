package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Hourly(
    @SerializedName("cloudcover")
    val cloudCover: List<Int>,
    @SerializedName("rain")
    val rain: List<Double>,
    @SerializedName("showers")
    val showers: List<Double>,
    @SerializedName("snowfall")
    val snowfall: List<Double>,
    @SerializedName("surface_pressure")
    val surfacePressure: List<Double>,
    @SerializedName("temperature_2m")
    val temperature2m: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("uv_index")
    val uvIndex: List<Double>,
    @SerializedName("weathercode")
    val weatherCode: List<Int>,
    @SerializedName("windspeed_10m")
    val windspeed10m: List<Double>
)