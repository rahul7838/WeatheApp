package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.data.WeatherServiceProvider
import com.example.weatherapp.data.WeatherServiceProviderImpl
import com.example.weatherapp.ui.WeatherContract
import com.example.weatherapp.ui.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class WeatherDiModule {

    @Provides
    fun provideServiceCall(): WeatherServiceProvider {
        return WeatherServiceProviderImpl()
    }

    @Provides
    fun provideWeatherPresenter(weatherServiceProvider: WeatherServiceProvider): WeatherContract.Presenter {
        return WeatherPresenter(weatherServiceProvider)
    }
}