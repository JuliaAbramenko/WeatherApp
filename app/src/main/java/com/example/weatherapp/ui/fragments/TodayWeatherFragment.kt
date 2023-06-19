package com.example.weatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.data.db.WeatherDatabase
import com.example.weatherapp.data.db.converter.Converters
import com.example.weatherapp.databinding.FragmentTodayWeatherBinding
import com.example.weatherapp.ui.viewmodels.WeatherTodayViewModel
import com.example.weatherapp.util.WeatherCodeAndTimeToIcon


class TodayWeatherFragment(val database: WeatherDatabase) : Fragment() {
    private val viewModel: WeatherTodayViewModel by viewModels()
    private lateinit var binding : FragmentTodayWeatherBinding
    private var codeTransformer = WeatherCodeAndTimeToIcon()
    private var converter = Converters()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayWeatherBinding.inflate(inflater, container, false)
        binding.todayWeatherViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}