package com.example.weatherapp.db.database


import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.apimodel.WeatherModelTest
import com.example.weatherapp.data.db.WeatherDao
import com.example.weatherapp.data.db.WeatherDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EntitiesReadWriteTests {

    private lateinit var weatherDao: WeatherDao
    private lateinit var db: WeatherDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, WeatherDatabase::class.java).build()
        weatherDao = db.weatherDao()
    }



    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun checkCurrentWeatherEntityInserted() {
        val model = WeatherModelTest().createWeatherModel()
        val currentWeatherEntity = model.toCurrentWeatherEntity()
        runBlocking {
            weatherDao.insertCurrentWeather(currentWeatherEntity)
            assertEquals(weatherDao.getCurrentWeather(),currentWeatherEntity)
        }
    }



}