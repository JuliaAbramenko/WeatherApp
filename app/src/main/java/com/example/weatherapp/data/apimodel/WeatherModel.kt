package com.example.weatherapp.data.apimodel

import android.util.Log
import com.example.weatherapp.data.db.CurrentWeatherEntity
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.db.converter.Converters
import com.google.gson.annotations.SerializedName
import okhttp3.internal.toImmutableList
import java.time.format.DateTimeParseException

data class WeatherModel(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    @SerializedName("daily")
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    @SerializedName("elevation")
    val elevation: Double,
    @SerializedName("hourly")
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
) {
    fun toDailyWeatherEntities(): List<DailyWeatherEntity> {
        val converter = Converters()
        val list: MutableList<DailyWeatherEntity> = mutableListOf()

        for(i in 0 until this.daily.time.size) {
            try {
                val localDateTimestamp = converter.stringToLocalDate(this.currentWeather.time)
                list.add(
                    DailyWeatherEntity(
                        converter.localDateToLong(localDateTimestamp),
                        this.longitude,
                        this.latitude,
                        converter.stringToLocalDate(this.daily.time[i]),
                        this.daily.weatherCode[i],
                        this.daily.temperature2mMax[i],
                        this.daily.temperature2mMin[i],
                        this.daily.sunrise[i],
                        this.daily.sunset[i]
                    ))
            } catch (dateTimeParseException: DateTimeParseException) {
                Log.e("DateTimeParse", dateTimeParseException.message!!)
                throw dateTimeParseException
            }
        }
        return list.toImmutableList()
    }

    fun toCurrentWeatherEntity(): CurrentWeatherEntity {
        val converter = Converters()
        val localDateTimestamp = converter.stringToLocalDate(this.currentWeather.time)
        return CurrentWeatherEntity(
            converter.localDateToLong(localDateTimestamp),
            this.longitude,
            this.latitude,
            this.currentWeather.temperature,
            this.currentWeather.windSpeed,
            this.currentWeather.weatherCode,
            this.currentWeather.isDay == 1
        )
    }



}