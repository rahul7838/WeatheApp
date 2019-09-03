package com.example.weatherapp.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApplication
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet2.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_progress.*
import kotlinx.android.synthetic.main.weather_error.*
import java.util.*
import javax.inject.Inject


class WeatherActivity : AppCompatActivity(), WeatherContract.View, LocationListener {

    private var cityName = ""

    override fun showErrorScreen() {
        error_layout.visibility = View.VISIBLE
    }

    private val MY_PERMISSIONS_REQUEST_LOCATION: Int = 10

    @Inject
    lateinit var presenter: WeatherContract.Presenter

    private lateinit var bottomSheet: BottomSheetBehavior<View>

    override fun showLoading() {
        spinner_layout.visibility = View.VISIBLE
        spinner.setImageDrawable(resources.getDrawable(R.drawable.ic_loading))
        val rotate = RotateAnimation(
            0f, 360f, Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 2000
        rotate.interpolator = LinearInterpolator()
        rotate.repeatMode = Animation.RESTART
        rotate.repeatCount = Animation.INFINITE
        spinner.startAnimation(rotate)

        layout_bottom_sheet_id.visibility = View.GONE
        content_main_id.visibility = View.GONE
    }

    override fun hideLoading() {
        spinner_layout.visibility = View.GONE
    }

    override fun showWeatherData(listOfDayTemp: ArrayList<Pair<String, String>>) {
        id_temp.text = listOfDayTemp[0].first
        id_location.text = cityName
        unit.text = resources.getString(R.string.degree)
        recycler_view_id.adapter =
            RecyclerViewAdapter(listOfDayTemp as ArrayList<Pair<String, String>>)
        val moveAnimation = AnimationUtils.loadAnimation(this, R.anim.slid_up_anim)
        layout_bottom_sheet_id.startAnimation(moveAnimation)
        content_main_id.visibility = View.VISIBLE
        layout_bottom_sheet_id.visibility = View.VISIBLE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.getInstance().weatherComponent.inject(this)
        setContentView(R.layout.activity_main)
        checkForPermission()
        recycler_view_id.layoutManager = LinearLayoutManager(this)
    }

    private fun checkForPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                MY_PERMISSIONS_REQUEST_LOCATION
            )

        } else {
            return
        }

    }

    private fun getData() {
        showLoading()
        val cityName = getCurrentLocation()
        presenter.attachView(this)
        presenter.getWeatherData(cityName)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    return
                } else {
                    Toast.makeText(
                        this,
                        "Permission required to show weather data",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }


    private fun getCurrentLocation(): String {
        var locationManager = this
            .getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isNetworkEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (!isNetworkEnable) {
            this.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
            ) {

                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    60000, 10f, this
                )
                val location: Location = locationManager
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                val latitude = location.latitude
                val longitude = location.longitude
                val geocoder = Geocoder(this, Locale.getDefault())
                val address = geocoder.getFromLocation(latitude, longitude, 1)
                cityName = address[0].locality
            }
        }
            return cityName
    }


    override fun onStart() {
        super.onStart()
        getData()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onLocationChanged(location: Location?) {
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }

}
