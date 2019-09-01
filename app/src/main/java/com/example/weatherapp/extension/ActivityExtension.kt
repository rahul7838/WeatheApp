package com.example.weatherapp.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.add(fragment: Fragment,
                          resContainer: Int,
                          isBackStack: Boolean = true,
                          backStackName: String? = fragment.javaClass.canonicalName) {
    with(this.supportFragmentManager?.beginTransaction()) {
        if(isBackStack) {
            this?.addToBackStack(backStackName)
        }
        this?.add(resContainer, fragment, backStackName)
        this?.commit()
    }
}