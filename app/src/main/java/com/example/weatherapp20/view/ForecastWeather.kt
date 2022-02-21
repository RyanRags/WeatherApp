package com.example.weatherapp20.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.weatherapp20.databinding.DailyForcastLayoutBinding
import com.example.weatherapp20.model.ForecastWeatherResponse
import com.example.weatherapp20.model.WeatherItem
import com.example.weatherapp20.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastWeather: Fragment() {

    lateinit var binding: DailyForcastLayoutBinding
    //lateinit var data: List<WeatherItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DailyForcastLayoutBinding.inflate(inflater, container, false)

        displayCurrentWeather()



        return binding.root
    }

    private fun displayCurrentWeather(){
        viewModel.getDataForcastWeather().enqueue(object : Callback<ForecastWeatherResponse>{
            override fun onResponse(
                call: Call<ForecastWeatherResponse>,
                response: Response<ForecastWeatherResponse>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        displayForecast(it.list)
                    }
                }
            }

            override fun onFailure(call: Call<ForecastWeatherResponse>, t: Throwable) {

            }
        })
    }

    private fun displayForecast(data: List<WeatherItem>){
        binding.dayOfWeather.layoutManager = GridLayoutManager(context, 3)
        binding.dayOfWeather.adapter = ForecastWeatherAdapter(data.map {
            WeatherItem(it.main,
            it.weather,
            it.dt_txt
            )
        })
    }
}