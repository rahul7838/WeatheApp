package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.ui.WeatherActivity
import dagger.Component

@Component(modules = [WeatherDiModule::class])
interface WeatherComponent {
    fun inject(weatherActivity: WeatherActivity)
}