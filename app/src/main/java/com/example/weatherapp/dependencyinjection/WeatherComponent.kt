package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.ui.WeatherActivity
import com.example.weatherapp.ui.WeatherFragment
import com.example.weatherapp.ui.WeatherPresenter
import dagger.Component

@Component(modules = [WeatherDiModule::class])
interface WeatherComponent {
    fun inject(weatherActivity: WeatherActivity)
    fun inject(weatherFragment: WeatherFragment)

}