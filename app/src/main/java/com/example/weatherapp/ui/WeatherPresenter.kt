package com.example.weatherapp.ui

import com.example.weatherapp.data.ServiceCall
import com.example.weatherapp.data.model.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class WeatherPresenter(private val serviceCall: ServiceCall) : WeatherContract.Presenter {

    override var view: WeatherContract.View? = null

    override var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun getWeatherData() {
        view?.showLoading()
        serviceCall.getWeatherResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess{view?.hideLoading()}
            .subscribe({ success -> handleSuccessResult(success)},
                { error -> handleFailureResult(error)})
            .addTo(compositeDisposable)
    }

    private fun handleFailureResult(error: Throwable) {

    }

    private fun handleSuccessResult(success: WeatherResponse) {
        val avgTemp = success.forecast.forecastday[0].day.avgtemp_c
    }
}