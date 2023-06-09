package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.apimodel.WeatherModel
import retrofit2.Response

interface WeatherRemoteDataSource {
    suspend fun getWeather(): Response<WeatherModel>
}