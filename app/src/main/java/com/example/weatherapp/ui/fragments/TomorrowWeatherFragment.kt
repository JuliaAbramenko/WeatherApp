package com.example.weatherapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.R
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.databinding.FragmentTodayWeatherBinding
import com.example.weatherapp.databinding.FragmentTomorrowWeatherBinding
import com.example.weatherapp.util.WeatherCodeAndTimeToIcon
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class TomorrowWeatherFragment : Fragment() {

    private lateinit var binding : FragmentTomorrowWeatherBinding
    private var codeTransformer = WeatherCodeAndTimeToIcon()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTomorrowWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setData(dailyWeatherEntities: List<DailyWeatherEntity>){
        val weatherImage = codeTransformer.getIcon(true, dailyWeatherEntities[1].dailyWeatherCode)
        binding.tomorrowWeatherIcon.setImageResource(weatherImage)

        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        binding.tomorrowWeatherDateTitle.text = dailyWeatherEntities[1].timestamp.toString().format(formatter)
        binding.tomorrowWeatherMaxTemp.text = dailyWeatherEntities[1].dailyTemperature2mMax.toString()
        binding.tomorrowWeatherMinTemp.text = dailyWeatherEntities[1].dailyTemperature2mMin.toString()
    }
}