package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.data.api.OpenMeteoService
import com.example.weatherapp.data.enums.DailyEnum
import com.example.weatherapp.data.enums.HourlyEnum
import com.example.weatherapp.data.enums.WindSpeedUnitsEnum
import com.example.weatherapp.data.model.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    //private var longitude = 0.0
    //private var latitude = 0.0
    private var requestCurrentWeather = true

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: request longitude and latitude from GPS
        /*
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

            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            if (location != null) {
                latitude = location.latitude;
                longitude = location.longitude;

            }
        }
*/

        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient: OkHttpClient.Builder  = OkHttpClient.Builder()
            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging)
            }

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.open-meteo.com/")
            .client(httpClient.build())
            .build()

        val apiService = retrofit.create(OpenMeteoService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<WeatherModel>  = apiService.getWeather(
                48.39,
                10.01,
                "Europe/Berlin",
                10,
                WindSpeedUnitsEnum.KMH.rep,
                requestCurrentWeather,

                listOf(HourlyEnum.WEATHERCODE.rep,HourlyEnum.TEMPERATURE_2M.rep,HourlyEnum.SURFACE_PRESSURE.rep,HourlyEnum.CLOUDCOVER.rep,HourlyEnum.SNOWFALL.rep,HourlyEnum.RAIN.rep,HourlyEnum.SHOWERS.rep, HourlyEnum.UV_INDEX.rep),
                listOf(DailyEnum.WEATHERCODE.rep,DailyEnum.TEMPERATURE_2M_MAX.rep, DailyEnum.TEMPERATURE_2M_MIN.rep,DailyEnum.SUNRISE.rep,DailyEnum.SUNSET.rep)
            )
            Log.i("Retrofit","COROUTINE EXECUTED WITH $response.code")
        }

    }
}