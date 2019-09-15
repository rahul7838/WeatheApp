package com.example.weatherapp.ui

import com.example.weatherapp.BaseContract

interface WeatherContract {

    interface View : BaseContract.BaseView{
        fun showWeatherData(listOfDayTemp: ArrayList<Pair<String, String>>)
        fun showErrorScreen()
    }


    interface Presenter : BaseContract.BasePresenter<View> {
        fun getWeatherData(cityName: String)
    }
}