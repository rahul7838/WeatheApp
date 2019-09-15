package com.example.weatherapp.ui

import com.example.weatherapp.MockDataProvider
import com.example.weatherapp.data.WeatherServiceProvider
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class WeatherPresenterTest {

    @Mock
    lateinit var weatherServiceProvider: WeatherServiceProvider

    @Mock
    lateinit var view: WeatherContract.View

    lateinit var presenter: WeatherPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxUnitTestTool.asyncToSync()
        presenter = WeatherPresenter(weatherServiceProvider)
        presenter.attachView(view)
    }

    @After
    fun tearDown() {
        presenter.detachView()
    }

    @Test
    fun getWeatherDataSuccessTest() {
        val listPair = arrayListOf(Pair("86.22", "Monday"))
        Mockito.`when`(weatherServiceProvider.getWeatherResponse("Bangalore"))
            .thenReturn(Single.just(MockDataProvider.getWeatherResponseSuccess()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(weatherServiceProvider).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showWeatherData(listPair)
    }

    @Test
    fun getWeatherDataErrorTest() {
        Mockito.`when`(weatherServiceProvider.getWeatherResponse("Bangalore"))
            .thenReturn(Single.error(MockDataProvider.getWeatherResponseError()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(weatherServiceProvider).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showErrorScreen()
    }
}