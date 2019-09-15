package com.example.weatherapp.error

class WeatherErrorPresenter : WeatherErrorContract.Presenter {

    private var view: WeatherErrorContract.View? = null

    override fun attachView(view: WeatherErrorContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}