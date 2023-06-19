package com.example.weatherapp.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.icu.util.TimeZone
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.R
import com.example.weatherapp.adapter.ViewPagerAdapter
import com.example.weatherapp.data.api.OpenMeteoService
import com.example.weatherapp.data.apimodel.WeatherModel
import com.example.weatherapp.data.datasource.WeatherLocalDataSource
import com.example.weatherapp.data.datasource.WeatherRemoteDataSource
import com.example.weatherapp.data.datasourceimpl.WeatherRemoteDataSourceImpl
import com.example.weatherapp.data.db.WeatherDatabase
import com.example.weatherapp.data.enums.DailyEnum
import com.example.weatherapp.data.enums.HourlyEnum
import com.example.weatherapp.data.enums.WindSpeedUnitsEnum
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var longitude = 0.0
    private var latitude = 0.0
    private lateinit var timeZone : TimeZone
    private var requestCurrentWeather = true
    private val tabsArray = arrayOf("Heute", "Morgen", "10 Tage")
    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherRemoteDataSource : WeatherRemoteDataSource
    private lateinit var database : WeatherDatabase



    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findLongitudeAndLatitude()
        getTimeZone()
        startRetrofit()
        initDataSources()
        setUpTabLayout()
    }

    private fun initDataSources() {
        database = WeatherDatabase.getDatabase(applicationContext)
        val handler = Handler(Looper.getMainLooper())
        val runnable: Runnable = object : Runnable {
            override fun run() {
                CoroutineScope(Dispatchers.IO).launch {
                    val body = weatherRemoteDataSource.getWeather().body()!!
                    val forecast = body.toDailyWeatherEntities()
                    val current = body.toCurrentWeatherEntity()
                    database.weatherDao().insertDailyWeather(forecast)
                    database.weatherDao().insertCurrentWeather(current)
                }
                handler.postDelayed(this, 30000)
            }
        }
    }

    override fun onStart() {
        super.onStart()

    }

    private fun getTimeZone() {
        timeZone = TimeZone.getDefault()
    }

    private fun startRetrofit() {

        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
        }

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.open-meteo.com/")
            .client(httpClient.build())
            .build()

        val apiService = retrofit.create(OpenMeteoService::class.java)

        weatherRemoteDataSource = WeatherRemoteDataSourceImpl(apiService,
            48.39,
            10.01,
            "Europe/Berlin",
            10,
            WindSpeedUnitsEnum.KMH.rep,
            requestCurrentWeather,
            listOf(HourlyEnum.WEATHERCODE.rep,HourlyEnum.TEMPERATURE_2M.rep,HourlyEnum.SURFACE_PRESSURE.rep,HourlyEnum.CLOUDCOVER.rep,HourlyEnum.SNOWFALL.rep,HourlyEnum.RAIN.rep,HourlyEnum.SHOWERS.rep, HourlyEnum.UV_INDEX.rep),
            listOf(DailyEnum.WEATHERCODE.rep,DailyEnum.TEMPERATURE_2M_MAX.rep, DailyEnum.TEMPERATURE_2M_MIN.rep,DailyEnum.SUNRISE.rep,DailyEnum.SUNSET.rep)
        )


    }

    private fun findLongitudeAndLatitude() {
        try {
            if (ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    101
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0F, LocationListener{

        })
        if (locationManager != null) {

            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

            if (location != null) {
                latitude = location.latitude
                longitude = location.longitude
            }
        }

    }

    private fun setUpTabLayout() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        val adapter = ViewPagerAdapter(weatherRemoteDataSource, database,supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager) {
                tab, position -> tab.text = tabsArray[position]
        }.attach()

    }
}