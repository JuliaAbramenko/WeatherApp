package com.example.weatherapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.data.db.converter.Converters
import java.util.concurrent.ExecutorService


@Database(entities = [DailyWeatherEntity::class, CurrentWeatherEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var weatherDatabase: WeatherDatabase? = null
        fun getDatabase(context: Context): WeatherDatabase {
            if (weatherDatabase == null) {
                synchronized(WeatherDatabase::class.java) {
                    if (weatherDatabase == null) {
                        weatherDatabase = databaseBuilder(
                            context.applicationContext,
                            WeatherDatabase::class.java, "weather_database"
                        )
                            .build()
                    }
                }
            }
            return weatherDatabase!!
        }
    }




}