package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.db.DailyWeatherEntity
import com.example.weatherapp.data.db.converter.Converters
import com.example.weatherapp.databinding.DailyWeatherListItemBinding
import com.example.weatherapp.util.WeatherCodeAndTimeToIcon

class DailyWeatherAdapter (private val dailyWeatherList : List<DailyWeatherEntity>) : RecyclerView.Adapter<DailyWeatherAdapter.WeatherViewHolder>() {
    inner class WeatherViewHolder (private val itemBinding: DailyWeatherListItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
            var image : ImageView = itemBinding.listItemImageView
            var date : TextView = itemBinding.listItemDateTextView
            var sunrise : TextView = itemBinding.listItemWeatherSunrise
            var sunset : TextView = itemBinding.listItemWeatherSunset
            var minTemp : TextView = itemBinding.listItemMinTemperatureTextview
            var maxTemp : TextView = itemBinding.listItemMaxTemperatureTextview

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(
            DailyWeatherListItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return  10
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.date.text = Converters().longToLocalDate(dailyWeatherList[position].timestamp).toString()
        holder.image.setImageResource(WeatherCodeAndTimeToIcon().getIcon(true,dailyWeatherList[position].dailyWeatherCode))
        holder.sunrise.text = dailyWeatherList[position].sunrise
        holder.sunset.text = dailyWeatherList[position].sunset
        holder.minTemp.text = dailyWeatherList[position].dailyTemperature2mMin.toString()
        holder.maxTemp.text = dailyWeatherList[position].dailyTemperature2mMax.toString()
    }
}