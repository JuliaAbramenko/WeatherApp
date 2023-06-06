package com.example.weatherapp.data.datasourceimpl

import com.example.weatherapp.data.api.OpenMeteoService
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.datasource.WeatherRemoteDataSource
import retrofit2.Response

class WeatherRemoteDataSourceImpl(
    private val openMeteoService: OpenMeteoService,
    private val longitude: Double,
    private val latitude: Double,
    private val timeZone: String,
    private val forecastDays: Int,
    private val windspeedUnit: String,
    private val currentWeather: Boolean,


    ) : WeatherRemoteDataSource {
    override suspend fun getWeather(): Response<WeatherModel> {
        return openMeteoService.getWeather(longitude, latitude,timeZone, forecastDays, windspeedUnit,currentWeather)
    }
}