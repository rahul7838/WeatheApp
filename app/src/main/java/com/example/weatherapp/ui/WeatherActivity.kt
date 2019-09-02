package com.example.weatherapp.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.content_main.*


class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    private lateinit var bottomSheet: BottomSheetBehavior<View>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        id_temp.typeface = getTypeFace("roboto_black.ttf")
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

//    private fun getTypeFace(fileName: String): Typeface {
//        return Typeface.createFromAsset(assets, "fonts/$fileName")
//    }
}
