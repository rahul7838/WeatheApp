package com.example.weatherapp.ui

import com.example.weatherapp.BaseContract
import com.example.weatherapp.data.model.error.Error

interface WeatherContract {

    interface View : BaseContract.BaseView {
        fun showWeatherData(listOfDayTemp: ArrayList<Pair<String, String>>)
        fun showErrorScreen(errorModel: Error)
    }


    interface Presenter : BaseContract.BasePresenter<View> {
        fun getWeatherData(cityName: String)
    }
}