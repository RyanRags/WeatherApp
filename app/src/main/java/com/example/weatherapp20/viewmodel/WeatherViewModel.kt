package com.example.weatherapp20.viewmodel


import androidx.lifecycle.ViewModel
import com.example.weatherapp20.model.*
import retrofit2.Call

private const val TAG = "WeatherViewModel"
class WeatherViewModel : ViewModel(){


    private var _tempatureUnits = Fahrenheit()
    val tempatureUnits: TempUnits
        get() = _tempatureUnits

    private var _zipCode = 30339
    val zipCode: Int
        get() = _zipCode


    fun getDataCurrentWeather():Call<CurrentWeatherResponse> {
        return Network.weatherApi.getCurrentWeather(zipCode, tempatureUnits.type)
    }

    fun getDataForcastWeather(): Call<ForecastWeatherResponse>{
        return Network.weatherApi.getForecastWeather(zipCode, tempatureUnits.type)
    }
}