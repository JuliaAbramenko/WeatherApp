package com.example.weatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.data.db.CurrentWeatherEntity
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.db.converter.Converters
import com.example.weatherapp.databinding.FragmentTodayWeatherBinding
import com.example.weatherapp.util.WeatherCodeAndTimeToIcon
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class TodayWeatherFragment : Fragment() {
    private lateinit var binding : FragmentTodayWeatherBinding
    private var codeTransformer = WeatherCodeAndTimeToIcon()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setData(currentWeatherEntity: CurrentWeatherEntity, dailyWeatherEntities: List<DailyWeatherEntity>) {
        val weatherImage = codeTransformer.getIcon(currentWeatherEntity.isDay,currentWeatherEntity.currentWeatherCode)
        binding.todayWeatherIcon.setImageResource(weatherImage)
        binding.todayWeatherCurrentTemp.text = currentWeatherEntity.currentTemperature.toString()

        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        binding.todayWeatherDateTitle.text = currentWeatherEntity.timestamp.toString().format(formatter)
        binding.todayWeatherMaxTemp.text = dailyWeatherEntities[0].dailyTemperature2mMax.toString()
        binding.todayWeatherMinTemp.text = dailyWeatherEntities[0].dailyTemperature2mMin.toString()
    }
}