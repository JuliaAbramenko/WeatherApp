package com.example.weatherapp.data.datasourceimpl

import com.example.weatherapp.data.api.OpenMeteoService
import com.example.weatherapp.data.model.WeatherModel
import com.example.weatherapp.data.datasource.WeatherRemoteDataSource
import com.example.weatherapp.data.enums.DailyEnum
import com.example.weatherapp.data.enums.HourlyEnum
import retrofit2.Response

class WeatherRemoteDataSourceImpl(
    private val openMeteoService: OpenMeteoService,
    private val longitude: Double,
    private val latitude: Double,
    private val timeZone: String,
    private val forecastDays: Int,
    private val windSpeedUnit: String,
    private val currentWeather: Boolean,
    private val hourlyParamList: List<String>,
    private val dailyParamList: List<String>


    ) : WeatherRemoteDataSource {
    override suspend fun getWeather(): Response<WeatherModel> {
        return openMeteoService.getWeather(longitude, latitude,timeZone, forecastDays, windSpeedUnit,currentWeather,hourlyParamList,dailyParamList)
    }
}