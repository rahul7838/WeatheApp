package com.example.weatherapp.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.component.PermissionFragment
import com.example.weatherapp.extension.add
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottom_sheet2.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.weather_error.*
import kotlinx.android.synthetic.main.weather_layout_container.*
import java.util.*
import javax.inject.Inject


class WeatherActivity : AppCompatActivity() {

    private var cityName = ""

    private lateinit var bottomSheet: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_layout_container)
        add(WeatherFragment(),R.id.container, false)
    }


//    private fun getData() {
//        showLoading()
//        val cityName = getCurrentLocation()
//        presenter.attachView(this)
//        presenter.getWeatherData(cityName)
//    }

//    private fun getCurrentLocation(): String {
//        var locationManager = this
//            .getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        val isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
//        if (!isNetworkEnable) {
//            this.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
//        } else {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED
//            ) {
//
//                locationManager.requestLocationUpdates(
//                    LocationManager.NETWORK_PROVIDER,
//                    60000, 10f, this
//                )
//                val location: Location = locationManager
//                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
//                val latitude = location.latitude
//                val longitude = location.longitude
//                val geocoder = Geocoder(this, Locale.getDefault())
//                val address = geocoder.getFromLocation(latitude, longitude, 1)
//                cityName = address[0].locality
//            }
//        }
//        return cityName
//    }


    //    override fun onLocationChanged(location: Location?) {
//    }
//
//    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
//    }
//
//    override fun onProviderEnabled(provider: String?) {
//    }
//
//    override fun onProviderDisabled(provider: String?) {
//    }

}
