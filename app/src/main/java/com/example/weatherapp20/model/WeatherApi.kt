package com.example.weatherapp20.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //http://api.openweathermap.org/data/2.5/forecast?zip=07410&appid=0a8eb07bbdd95ecde13c0c540fd2b492

    @GET(END_POINT)
    fun getCurrentWeather(
        @Query(ZIP) zipCode: Int,
        @Query(UNIT) unit: String,
        @Query(APPID) key: String = API_KEY
    ): Call<CurrentWeatherResponse>

    @GET(END_POINT_FULL)
    fun getForecastWeather(
        @Query(ZIP) zipCode: Int,
        @Query(UNIT) unit: String,
        @Query(APPID) key: String = API_KEY
    ): Call<ForecastWeatherResponse>

}