package com.example.weatherapp.ui

import com.example.weatherapp.MockDataProvider
import com.example.weatherapp.data.ServiceCall
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Test
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
        Mockito.`when`(serviceCall.getWeatherResponse("Bangalore"))
            .thenReturn(Single.just(MockDataProvider.getWeatherResponseSuccess()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(view).showLoading()
        Mockito.verify(serviceCall).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
    }

    @Test
    fun getWeatherDataErrorTest() {
        Mockito.`when`(serviceCall.getWeatherResponse("Bangalore"))
            .thenReturn(Single.error(MockDataProvider.getWeatherResponseError()))
        presenter.getWeatherData("Bangalore")
        Mockito.verify(view).showLoading()
        Mockito.verify(serviceCall).getWeatherResponse("Bangalore")
        Mockito.verify(view).hideLoading()
    }
}