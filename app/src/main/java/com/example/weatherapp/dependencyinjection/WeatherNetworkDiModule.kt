package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.data.WeatherServiceProvider
import com.example.weatherapp.data.WeatherServiceProviderImpl
import dagger.Module
import dagger.Provides

@Module
class WeatherNetworkDiModule {

    @Provides
    fun provideServiceCall(): WeatherServiceProvider {
        return WeatherServiceProviderImpl()
    }
}