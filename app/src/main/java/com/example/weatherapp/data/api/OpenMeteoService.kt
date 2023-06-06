package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoService {
    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude")
        latitude: Double,
        @Query("longitude")
        longitude: Double,
        @Query("timezone")
        timezone: String,
        @Query("forecast_days")
        forecastDays: Int,
        @Query("windspeed_unit")
        windspeedUnit: String,
        @Query("current_weather")
        currentWeather: Boolean
    ) : Response<WeatherModel>
}
