package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.ui.WeatherFragment
import dagger.Component

@Component(modules = [WeatherDiModule::class])
interface WeatherComponent {
    fun inject(weatherFragment: WeatherFragment)
}