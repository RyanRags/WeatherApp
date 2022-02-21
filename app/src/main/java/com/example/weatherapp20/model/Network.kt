package com.example.weatherapp20.model

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {

        val weatherApi: WeatherApi by lazy {
            initRetrofit().create(WeatherApi::class.java)
        }

        //If not getting the right data try RXJava
        private fun initRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
}