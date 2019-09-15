package com.example.weatherapp.error

interface WeatherErrorContract {

    interface View {

    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()
    }
}