package com.example.weatherapp.domain

import com.example.weatherapp.data.apimodel.WeatherModel
import retrofit2.Response

interface WeatherRepository {

    suspend fun getWeather(): Response<WeatherModel>
    suspend fun updateWeatherEntries()
}