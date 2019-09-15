package com.example.weatherapp.ui

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.component.PermissionFragment
import com.example.weatherapp.extension.gone
import com.example.weatherapp.extension.visible
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottom_sheet2.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_progress.*
import kotlinx.android.synthetic.main.weather_layout_container.*
import javax.inject.Inject

class WeatherFragment : Fragment(), WeatherContract.View {

    override fun showLoading() {
        spinner_layout.visible()
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

        layout_bottom_sheet_id.gone()
        content_main_id.visible()
    }

    override fun hideLoading() {
        spinner_layout.gone()
    }

    override fun showWeatherData(listOfDayTemp: ArrayList<Pair<String, String>>) {
        id_temp.text = listOfDayTemp[0].first
        id_location.text = "Bangalore"
        unit.text = resources.getString(R.string.degree)
        recycler_view_id.adapter =
            RecyclerViewAdapter(listOfDayTemp)
        val moveAnimation = AnimationUtils.loadAnimation(context, R.anim.slid_up_anim)
        layout_bottom_sheet_id.startAnimation(moveAnimation)
        content_main_id.visible()
        layout_bottom_sheet_id.visible()
    }

    override fun showErrorScreen() {

    }

    @Inject
    lateinit var presenter: WeatherContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.getInstance().weatherComponent.inject(this)
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return LayoutInflater.from(context).inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermissionAndExecute()
        recycler_view_id.layoutManager = LinearLayoutManager(context)
    }

    private fun checkPermissionAndExecute() {
        activity?.let {
            PermissionFragment.getPermissionFragment(it)
                .executeWithPermissionCheck(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    {
                        presenter.getWeatherData("Bangalore ")
                    },
                    this::permissionDenialHandling
                )
        }
    }

    private fun permissionDenialHandling(boolean: Boolean) {
        Snackbar.make(container, "permission is required", 5000)
        showBanner()
    }

    private fun showBanner() {
//        TODO show banner
    }


    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}