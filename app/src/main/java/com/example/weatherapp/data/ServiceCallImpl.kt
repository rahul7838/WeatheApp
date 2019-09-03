package com.example.weatherapp.data

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.networking.RetrofitApiClient
import com.example.weatherapp.networking.WeatherService
import io.reactivex.Single

class ServiceCallImpl : ServiceCall {

    companion object {
        const val KEY = "4153396161324c408c881756190109"
    }

    override fun getWeatherResponse(cityName: String): Single<WeatherResponse> {
        val service = RetrofitApiClient().getRetrofit().create(WeatherService::class.java)
        return service.getWeatherResponse(KEY, cityName, "5")
    }
}