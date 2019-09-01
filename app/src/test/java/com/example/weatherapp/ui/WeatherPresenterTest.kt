package com.example.weatherapp.ui

import com.example.weatherapp.MockDataProvider
import com.example.weatherapp.data.ServiceCall
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
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
        Mockito.`when`(serviceCall.getWeatherResponse())
            .thenReturn(Single.just(MockDataProvider.getWeatherResponse()))
        presenter.getWeatherData()
        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(serviceCall).getWeatherResponse()
    }
}