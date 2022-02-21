package com.example.weatherapp20.model

data class ForecastWeatherResponse(
    val list: List<WeatherItem>,
    val city: WeatherName
)

data class WeatherItem (val main: WeatherTemp,
                        val weather: List<WeatherGenre>,
                        val dt_txt: String
)

data class WeatherTemp(val temp: Double)

data class WeatherGenre(val main: String)


data class WeatherName(val name: String)