package com.example.weatherapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentTenDaysWeatherBinding

class TenDaysWeatherFragment : Fragment() {
    private lateinit var binding: FragmentTenDaysWeatherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTenDaysWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }
}