package com.example.weatherapp.dependencyinjection

import com.example.weatherapp.data.ServiceCall
import com.example.weatherapp.data.ServiceCallImpl
import com.example.weatherapp.ui.WeatherContract
import com.example.weatherapp.ui.WeatherPresenter
import dagger.Module
import dagger.Provides

@Module
class WeatherDiModule {

    @Provides
    fun provideServiceCall(): ServiceCall {
        return ServiceCallImpl()
    }

    @Provides
    fun provideWeatherPresenter(serviceCall: ServiceCall): WeatherContract.Presenter {
        return WeatherPresenter(serviceCall)
    }
}