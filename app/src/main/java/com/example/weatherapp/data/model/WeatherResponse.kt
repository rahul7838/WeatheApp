package com.example.weatherapp.data.model

import com.example.weatherapp.data.model.Alert
import com.example.weatherapp.data.model.Current
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.data.model.Location

data class WeatherResponse(
    val alert: Alert,
    val current: Current,
    val forecast: Forecast,
    val location: Location
)