package com.example.weatherapp20.view

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp20.R
import com.example.weatherapp20.databinding.WeatherLayoutItemBinding
import com.example.weatherapp20.model.ForecastWeatherResponse
import com.example.weatherapp20.model.WeatherItem

class ForecastWeatherViewHolder (private val binding: WeatherLayoutItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(volumeItem: WeatherItem){
        binding.tvTemp1.text = binding.root.context
            .getString(R.string.Degrees, volumeItem.main.temp.toString())
        binding.date.text = volumeItem.dt_txt.substring(5,10) + " " + volumeItem.dt_txt.substring(11, 16)
        when(volumeItem.weather[0].main){
            "Clear" -> binding.ivWeatherIcon1.setImageResource(R.drawable.sun)
            "Rain" -> binding.ivWeatherIcon1.setImageResource(R.drawable.rain)
            "Clouds" -> binding.ivWeatherIcon1.setImageResource(R.drawable.cloud)
        }
    }
}