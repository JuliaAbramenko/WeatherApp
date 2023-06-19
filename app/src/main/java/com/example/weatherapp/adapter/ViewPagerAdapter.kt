package com.example.weatherapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.data.datasource.WeatherRemoteDataSource
import com.example.weatherapp.data.db.WeatherDatabase
import com.example.weatherapp.ui.fragments.TenDaysWeatherFragment
import com.example.weatherapp.ui.fragments.TodayWeatherFragment
import com.example.weatherapp.ui.fragments.TomorrowWeatherFragment

class ViewPagerAdapter (
    private val remoteDataSource: WeatherRemoteDataSource, private val database: WeatherDatabase,
    fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return TodayWeatherFragment(database)
            1 -> return TomorrowWeatherFragment()
        }
        return TenDaysWeatherFragment()
    }
}