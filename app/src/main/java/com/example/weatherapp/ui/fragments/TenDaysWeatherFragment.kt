package com.example.weatherapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapter.DailyWeatherAdapter
import com.example.weatherapp.data.datasource.WeatherLocalDataSource
import com.example.weatherapp.data.db.converter.Converters
import com.example.weatherapp.databinding.FragmentTenDaysWeatherBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.time.LocalDate

class TenDaysWeatherFragment() : Fragment() {
    private lateinit var binding: FragmentTenDaysWeatherBinding
    private lateinit var converter: Converters
    private lateinit var localDataSource : WeatherLocalDataSource // ????
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recyclerView = binding.recyclerView
        if (container != null) {
            recyclerView.layoutManager = LinearLayoutManager(container.context, LinearLayoutManager.VERTICAL, false)
        }
        // Inflate the layout for this fragment
        binding = FragmentTenDaysWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        CoroutineScope(Dispatchers.IO).launch {
            val adapter = DailyWeatherAdapter(localDataSource.getWeather10Days(converter.localDateToLong(LocalDate.now()), converter.localDateToLong(LocalDate.now().plusDays(10)))) // ???
            binding.recyclerView.adapter = adapter
        }


    }


}