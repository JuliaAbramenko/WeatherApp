package com.example.weatherapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherTodayViewModel : ViewModel() {

    private var _image = MutableLiveData<Int>()
    val image: MutableLiveData<Int> get() = _image
    private var _date = MutableLiveData<String>()
    val date: MutableLiveData<String> get() = _date
    private var _tempMin = MutableLiveData<Double>()
    val tempMin: MutableLiveData<Double> get() = _tempMin
    private var _tempMax = MutableLiveData<Double>()
    val tempMax: MutableLiveData<Double> get() = _tempMax
    private var _currentTemp = MutableLiveData<Int>()
    val currentTemp: MutableLiveData<Int> get() = _currentTemp
    init {
        Log.d("TodayWeatherFragment", "TodayWeatherViewModel created!")
    }

}