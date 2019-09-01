package com.example.weatherapp

import com.example.weatherapp.data.model.*

sealed class MockDataProvider {
    companion object {

        fun getLocation(): Location {
            return Location(
                "India",
                23.18,
                "2019-09-01 13:50",
                1567326001,
                75.77,
                "ujjain",
                "MP",
                "Asia/Kolkata"
            )
        }

        fun getAlert(): Alert {
            return Alert()
        }

        fun getCurrent(): Current {
            return Current(
                1567325065,
                getConditionX(),
                31.22,
                31.22,
                27.3,
                81.1,
                1,
                6,
                "2019-09-01 13:34",
                277,
                1003.2,
                1003.22,
                30.1,
                0.22,
                23.220,
                .81,
                .44,
                31.01,
                87.8,
                10,
                "W",
                6.22,
                7.6
            )
        }

        fun getConditionX(): ConditionX {
            return ConditionX(1006, "Cloudy", "//cdn.apixu.com/weather/64x64/day/119.png")
        }

        fun getAstro(): Astro {
            return Astro(
                "06:09 AM",
                "06:45 PM",
                "07:57 AM",
                "08:30 PM"
            )
        }

        fun getDay(): Day {
            return Day(
                30.22,
                86.22,
                23.1,
                73.6,
                25.9,
                getCondition(),
                13.4,
                21.6,
                33.8,
                1.33,
                6.4,
                3.22,
                87.22,
                11.4,
                2.2
            )
        }

        fun getCondition(): Condition {
            return Condition(
                1234,
                "//cdn.apixu.com/weather/64x64/day/356.png",
                "Moderate or heavy rain shower"
            )
        }

        fun getForeCastDay(): Forecastday {
            return Forecastday(getAstro(), "45", 878, getDay())
        }

        fun getForecast(): Forecast {
            return Forecast(
                arrayListOf(getForeCastDay())
            )
        }

        fun getWeatherResponse(): WeatherResponse {
            return WeatherResponse(getAlert(), getCurrent(), getForecast(), getLocation())
        }

    }
}