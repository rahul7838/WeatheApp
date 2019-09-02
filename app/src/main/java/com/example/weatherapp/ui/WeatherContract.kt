package com.example.weatherapp.ui

import com.example.weatherapp.BaseContract

interface WeatherContract {

    interface View : BaseContract.BaseView {
        fun showWeatherData()
        fun showErroScreen()
    }


    interface Presenter : BaseContract.BasePresenter<View> {
        fun getWeatherData()
    }
}