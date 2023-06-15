package com.example.weatherapp.util

import com.example.weatherapp.R

class WeatherCodeAndTimeToIcon(){

    fun getIcon(isDay: Boolean, weatherCode: Int): Int{
        var icon = 0
        when(weatherCode) {
           0 -> icon = if(isDay) R.drawable.code0_day else R.drawable.code0_night
            1,2 -> icon = if(isDay) R.drawable.code1_2_day else R.drawable.code1_2_night
            3 -> icon = R.drawable.code3
            45,48 -> icon = if(isDay) R.drawable.code45_48_day else R.drawable.code45_48_night
            51 -> icon = if(isDay) R.drawable.code51_day else R.drawable.code51_night
            53 -> icon = if(isDay) R.drawable.code53_day else R.drawable.code53_night
            55 -> icon = if(isDay) R.drawable.code55_day else R.drawable.code55_night
            56 -> icon = R.drawable.code56
            57 -> icon = R.drawable.code57
            61,66 ->  icon = R.drawable.code61_66
            63 -> icon = R.drawable.code63
            65,67 -> icon = R.drawable.code65_67
            71, 73 -> icon = if(isDay) R.drawable.code71_73_day else R.drawable.code71_73_night
            75 -> icon = R.drawable.code75
            77 -> icon = R.drawable.code77
            80 -> icon = R.drawable.code80
            81 -> icon = R.drawable.code81
            82 -> icon = R.drawable.code82
            85 -> icon = if(isDay) R.drawable.code85_day else R.drawable.code85_night
            86 -> icon = R.drawable.code86
            95 -> icon = R.drawable.code95
            96 -> icon = R.drawable.code96
            99 -> icon = R.drawable.code99
        }
        return icon
    }
}