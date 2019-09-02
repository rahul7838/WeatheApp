package com.example.weatherapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApplication
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_progress.*
import javax.inject.Inject


class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    override fun showErroScreen() {

    }

    @Inject
    lateinit var presenter: WeatherContract.Presenter

    private lateinit var bottomSheet: BottomSheetBehavior<View>

    override fun showLoading() {
        progress_bar_id.visibility = View.VISIBLE
        layout_bottom_sheet_id.visibility = View.GONE
        content_main_id.visibility = View.GONE
    }

    override fun hideLoading() {
        progress_bar_id.visibility = View.GONE

    }

    override fun showWeatherData() {
        layout_bottom_sheet_id.visibility = View.VISIBLE
        content_main_id.visibility = View.VISIBLE
        bottomSheet = BottomSheetBehavior.from(layout_bottom_sheet_id)
        bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {

            }

            override fun onStateChanged(p0: View, p1: Int) {

            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.getInstance().weatherComponent.inject(this)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        presenter.getWeatherData()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
