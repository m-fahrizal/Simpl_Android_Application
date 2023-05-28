package com.example.finalproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bike(
    val name: String,
    val description: String,
    val photo: Int,
    val oldPrice: String,
    val newPrice: String
) : Parcelable
