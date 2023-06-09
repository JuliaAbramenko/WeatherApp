package com.example.weatherapp.data.api

import com.example.weatherapp.data.apimodel.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoService {
    @GET("v1/forecast")
    @JvmSuppressWildcards
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
        windSpeedUnit: String,
        @Query("current_weather")
        currentWeather: Boolean,
        @Query("hourly")
        hourlyParams: List<String>,
        @Query("daily")
        dailyParams: List<String>
    ) : Response<WeatherModel>
}
