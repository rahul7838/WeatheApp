package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherResponse
import io.reactivex.Single

interface WeatherServiceProvider {
    fun getWeatherResponse(cityName: String): Single<WeatherResponse>
}