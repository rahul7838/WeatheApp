package com.example.weatherapp.data.model.error

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Error(
    val code: Int,
    val info: String,
    val type: String
) : Parcelable