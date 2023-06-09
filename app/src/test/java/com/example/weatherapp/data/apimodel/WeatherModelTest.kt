package com.example.weatherapp.data.apimodel

import com.example.weatherapp.data.db.CurrentWeatherEntity
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.db.converter.Converters
import org.junit.Test
import java.time.LocalDateTime
import org.junit.Assert.*
import java.time.LocalDate
import java.util.Date

class WeatherModelTest {


    @Test
    fun toDailyWeatherEntities() {
        val model = createWeatherModel()
        val dailyWeatherEntities = model.toDailyWeatherEntities()
        val shouldBe = DailyWeatherEntity(
            "2023-06-09T18:00",
            10.02,
            48.38,
            Converters().stringToLocalDate("2023-06-09"),
            2,
            25.1,
            10.2,
            "2023-06-09T05:17",
            "2023-06-09T21:21"
            )
        assertEquals(dailyWeatherEntities[0], shouldBe)
    }

    @Test
    fun toCurrentWeatherEntity() {
        val model = createWeatherModel()
        val currentWeatherEntity = model.toCurrentWeatherEntity()
        val shouldBe = CurrentWeatherEntity(
            "2023-06-09T18:00",
            10.02,
            48.38,
            24.6,
            20.0,
            1
        )
        assertEquals(currentWeatherEntity, shouldBe)
    }

    fun createWeatherModel() : WeatherModel {
        val currentWeather = CurrentWeather(
            1, 24.6,"2023-06-09T18:00", 1, 64.0, 20.0
        )
        val daily = Daily(
            listOf(
                "2023-06-09T05:17",
                "2023-06-10T05:16",
                "2023-06-11T05:16",
                "2023-06-12T05:16",
                "2023-06-13T05:16",
                "2023-06-14T05:16",
                "2023-06-15T05:16",
                "2023-06-16T05:16",
                "2023-06-17T05:16",
                "2023-06-18T05:16"
            ),
            listOf(
                "2023-06-09T21:21",
                "2023-06-10T21:21",
                "2023-06-11T21:22",
                "2023-06-12T21:22",
                "2023-06-13T21:23",
                "2023-06-14T21:24",
                "2023-06-15T21:24",
                "2023-06-16T21:25",
                "2023-06-17T21:25",
                "2023-06-18T21:25"
            ),
            listOf(
                25.1,
                25.5,
                25.8,
                24.8,
                23.4,
                21.6,
                17.9,
                18.4,
                19.6,
                20.5
            ),
            listOf(
                10.2,
                11.9,
                12.7,
                12.7,
                9.2,
                9.0,
                9.8,
                7.3,
                9.3,
                11.9
            ),
            listOf(
                "2023-06-09",
                "2023-06-10",
                "2023-06-11",
                "2023-06-12",
                "2023-06-13",
                "2023-06-14",
                "2023-06-15",
                "2023-06-16",
                "2023-06-17",
                "2023-06-18"
            ),
            listOf(
                2,
                2,
                2,
                2,
                0,
                2,
                80,
                61,
                3,
                51
            )

        )
        val dailyUnits = DailyUnits("iso8601", "iso8601", "°C", "°C", "iso8601", "wmo code")

        val elevation = 476.0

        // lists of hourly irrelevant for DB
        val zeroDoubleList = (0..99).map { _ -> 0.0 }
        val zeroIntList = (0..99).map { _ -> 0 }
        val emptyStringList = (0..99).map { _ -> "" }
        val hourly = Hourly(
            zeroIntList,
            zeroDoubleList,
            zeroDoubleList,
            zeroDoubleList,
            zeroDoubleList,
            zeroDoubleList,
            emptyStringList,
            zeroDoubleList,
            zeroIntList,
            zeroDoubleList
        )

        val hourlyUnits = HourlyUnits("%","mm", "mm", "mm","hPa","°C", "iso8601", "","wmo code", "km/h")
        val latitude = 48.38
        val longitude = 10.02
        val timezone = "Europe/Berlin"
        val timeZoneAbbr = "CEST"
        return WeatherModel(currentWeather, daily, dailyUnits, elevation, hourly, hourlyUnits, latitude, longitude,timezone, timeZoneAbbr)
    }
}