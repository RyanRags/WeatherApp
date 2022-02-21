package com.example.weatherapp20.model


data class CurrentWeatherResponse(
    val weather: List<WeatherDescription>,
    val main: MainItem,
    val name: String
)
data class MainItem(val temp: Double)

data class WeatherDescription(
    val main: String
)
