package com.example.weatherapp.data.model

data class WeatherResponse(
    val alert: Alert,
    val current: Current,
    val forecast: Forecast,
    val location: Location
)