package com.example.weatherapp.data.model.error

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorViewModel(
    val error: Error,
    val success: Boolean
) : Parcelable