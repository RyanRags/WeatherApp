package com.example.weatherapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp20.view.CurrentWeather
import com.example.weatherapp20.view.ForecastWeather
import com.example.weatherapp20.viewmodel.WeatherViewModel

    val viewModel: WeatherViewModel by lazy {
        WeatherViewModel()
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.container_current_weather, CurrentWeather())
            .addToBackStack(null)
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.daily_weather_forcast, ForecastWeather())
            .addToBackStack(null)
            .commit()

    }

    override fun onStart() {
        super.onStart()

    }



}