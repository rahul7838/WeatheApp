package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.error.WeatherErrorFragment
import com.example.weatherapp.ui.WeatherFragment
import dagger.Component

@Component(modules = [WeatherNetworkDiModule::class, WeatherDiModule::class])
interface WeatherComponent {
    fun inject(weatherFragment: WeatherFragment)
    fun inject(weatherErrorFragment: WeatherErrorFragment)

}