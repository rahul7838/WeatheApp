package com.example.weatherapp.ui

import com.example.weatherapp.data.WeatherServiceProvider
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.model.error.Error
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.*

class WeatherPresenter(private val weatherServiceProvider: WeatherServiceProvider) : WeatherContract.Presenter {

    override var view: WeatherContract.View? = null

    override var compositeDisposable: CompositeDisposable = CompositeDisposable()


    override fun getWeatherData(cityName: String) {
        view?.showLoading()
        weatherServiceProvider.getWeatherResponse(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ success -> handleSuccessResult(success)},
                { error ->
                    run {
                        val error1 = error
                        handleFailureResult(error as HttpException)
                    }
                })
            .addTo(compositeDisposable)
    }

    private fun handleFailureResult(error: HttpException) {
        view?.hideLoading()
        val errorModel = Error(error.code(), error.message(), error.message())
        view?.showErrorScreen(errorModel)
    }

    private fun handleSuccessResult(success: WeatherResponse) {
        view?.hideLoading()
        val forecast = success.forecast
        val listPair = arrayListOf<Pair<String, String>>()
        for (i in forecast.forecastday.indices) {
            val date = forecast.forecastday[i].date
            val day = getDay(date)
            listPair.add(Pair(forecast.forecastday[i].day.avgtemp_c.toString(), day))
        }
        view?.showWeatherData(listPair)
    }

    private fun getDay(dateString: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = format.parse(dateString)

        val c = Calendar.getInstance()
        c.time = date
        return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault())
    }
}