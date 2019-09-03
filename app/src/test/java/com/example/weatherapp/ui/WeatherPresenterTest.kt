package com.example.weatherapp.ui

import com.example.weatherapp.MockDataProvider
import com.example.weatherapp.data.ServiceCall
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class WeatherPresenterTest {

    @Mock
    lateinit var serviceCall: ServiceCall

    @Mock
    lateinit var view: WeatherContract.View

    lateinit var presenter: WeatherPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxUnitTestTool.asyncToSync()
        presenter = WeatherPresenter(serviceCall)
        presenter.attachView(view)
    }

    @After
    fun tearDown() {
        presenter.detachView()
    }

    @Test
    fun getWeatherDataSuccessTest() {
        val listPair = arrayListOf(Pair("86.22", "Monday"))
        Mockito.`when`(serviceCall.getWeatherResponse("Bangalore"))
            .thenReturn(Single.just(MockDataProvider.getWeatherResponseSuccess()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(serviceCall).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showWeatherData(listPair)
    }

    @Test
    fun getWeatherDataErrorTest() {
        Mockito.`when`(serviceCall.getWeatherResponse("Bangalore"))
            .thenReturn(Single.error(MockDataProvider.getWeatherResponseError()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(serviceCall).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showErrorScreen()
    }
}