package com.example.weatherapp20.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.weatherapp20.R
import com.example.weatherapp20.databinding.CurrentWeatherLayoutBinding
import com.example.weatherapp20.model.CurrentWeatherResponse
import com.example.weatherapp20.viewModel
import com.example.weatherapp20.viewmodel.WeatherViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Array.newInstance

class CurrentWeather: Fragment() {

    private lateinit var binding: CurrentWeatherLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CurrentWeatherLayoutBinding.inflate(inflater, container, false)
        displayCurrentWeather()

        return binding.root
    }

    private fun displayCurrentWeather(){
        viewModel.getDataCurrentWeather().enqueue( object : Callback<CurrentWeatherResponse> {
            override fun onResponse(
                call: Call<CurrentWeatherResponse>,
                response: Response<CurrentWeatherResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        currentWeatherBinding(it)
                    }
                }
            }
            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
            }
        })
    }

    private fun currentWeatherBinding(weatherResponse: CurrentWeatherResponse) {
        binding.tvLocation.text = weatherResponse.name
        binding.tvSkys.text = weatherResponse.weather[0].main
        binding.tvWeather.text = binding.root.context
            .getString(R.string.Degrees, weatherResponse.main.temp.toString())
    }



}