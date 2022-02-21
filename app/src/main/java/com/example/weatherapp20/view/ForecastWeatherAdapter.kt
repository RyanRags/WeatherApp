package com.example.weatherapp20.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp20.databinding.WeatherLayoutItemBinding
import com.example.weatherapp20.model.WeatherItem

class ForecastWeatherAdapter(private val dataSet: List<WeatherItem>):
    RecyclerView.Adapter<ForecastWeatherViewHolder>() {

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ForecastWeatherViewHolder(
            WeatherLayoutItemBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: ForecastWeatherViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }
}