package com.example.weatherapp.networking

import com.example.weatherapp.data.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(".")
    fun getWeatherResponse(@Query("key")apiKey: String,@Query("q") location: String): Single<WeatherResponse>
}
