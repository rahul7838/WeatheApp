package com.example.weatherapp.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*

class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    private lateinit var bottomSheet: BottomSheetBehavior<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomSheet = BottomSheetBehavior.from(layout_bottom_sheet)
        bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {

            }

            override fun onStateChanged(p0: View, p1: Int) {

            }

        })
//        val weatherFragment = WeatherFragment()
//        add(weatherFragment, R.id.container, false)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED
    }
}
