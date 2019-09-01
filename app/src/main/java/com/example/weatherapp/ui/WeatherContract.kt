package com.example.weatherapp.ui

interface WeatherContract {

    interface View {

    }

    interface Presenter {
        fun getWeatherData()
    }
}