package com.example.weatherapp.data.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.data.db.converter.Converters

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}