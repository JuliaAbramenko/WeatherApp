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

class TomorrowWeatherFragment : Fragment() {

    private lateinit var binding : FragmentTomorrowWeatherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTomorrowWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setData(dailyWeatherEntities: List<DailyWeatherEntity>){

    }
}