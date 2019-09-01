package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.dependencyinjection.DaggerWeatherComponent
import com.example.weatherapp.dependencyinjection.WeatherComponent
import com.example.weatherapp.dependencyinjection.WeatherDiModule

class WeatherApplication : Application() {

    lateinit var weatherComponent: WeatherComponent

    companion object {
        private var INSTANCE = WeatherApplication()

        fun getInstance(): WeatherApplication {
            return INSTANCE
        }
    }

    init {
        initDi()
    }

    private fun initDi() {
        weatherComponent = DaggerWeatherComponent.builder()
            .weatherDiModule(WeatherDiModule())
            .build()
    }
}