package com.example.weatherapp.db.converter

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.data.db.converter.Converters
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeParseException

@RunWith(AndroidJUnit4::class)
class ConvertersTest {
    private var converter = Converters()
    @Before
    fun init(){
        converter = Converters()
    }
    @Test
    fun fromTimestampPos() {
        val localDateTime = converter.fromTimestamp("2023-06-07T16:00")
        assertEquals(localDateTime.dayOfMonth, 7)
        assertEquals(localDateTime.month, Month.JUNE)
        assertEquals(localDateTime.hour, 16)
        assertEquals(localDateTime.year, 2023)
        assertEquals(localDateTime.minute, 0)
    }

    @Test(expected = DateTimeParseException::class)
    fun fromTimeStampNeg() {
        converter.fromTimestamp("2023-06-56T16:000")
    }

    @Test
    fun localDateTimeToStringPos() {
        val localDateTime = LocalDateTime.of(2022,12,11,7, 45)
        assertEquals(converter.localDateTimeToString(localDateTime), "2022-12-11T07:45")
    }

    @Test
    fun stringToLocalDate() {
        val string = "2022-12-11"
        val localDate = LocalDate.of(2022, 12, 11)
        assertEquals(converter.stringToLocalDate(string), localDate)
    }

    @Test
    fun stringToLocalDate2() {
        val string = "2022-12-11T03:38"
        val localDate = LocalDate.of(2022, 12, 11)
        assertEquals(converter.stringToLocalDate(string), localDate)
    }

    @Test
    fun localDateToString() {
        val localDate = LocalDate.of(2023, 6, 9)
        assertEquals(converter.localDateToString(localDate), "2023-06-09")
    }

    @Test
    fun longToLocalDate() {
        val currentTimeMillis = System.currentTimeMillis()
        val result = LocalDate.now()
        assertEquals(converter.longToLocalDate(currentTimeMillis), result)
    }

    @Test
    fun localDateToLong() {
        val now = LocalDate.now()
        val currentTimeMillis = System.currentTimeMillis()
        // test should be executed only after midnight
        assert(currentTimeMillis > converter.localDateToLong(now))
    }
}