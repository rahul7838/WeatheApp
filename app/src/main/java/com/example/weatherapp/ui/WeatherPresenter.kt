package com.example.weatherapp.ui

import com.example.weatherapp.data.ServiceCall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(private val serviceCall: ServiceCall) : WeatherContract.Presenter {

    override fun getWeatherData() {
        serviceCall.getWeatherResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ success -> },
                { error -> })
    }
}