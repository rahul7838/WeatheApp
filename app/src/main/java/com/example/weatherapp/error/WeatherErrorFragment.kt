package com.example.weatherapp.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.data.model.error.Error
import com.example.weatherapp.utils.ERROR_MESSAGE_KEY
import javax.inject.Inject

class WeatherErrorFragment : Fragment(), WeatherErrorContract.View {

    @Inject
    lateinit var presenterWeather: WeatherErrorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.getInstance().weatherComponent.inject(this)
        presenterWeather.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return LayoutInflater.from(context).inflate(R.layout.weather_error, container, false)
    }

    companion object {
        fun instance(errorModel: Error): WeatherErrorFragment {
            val fragment = WeatherErrorFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(ERROR_MESSAGE_KEY, errorModel)
            }
            return fragment
        }
    }
}