package com.example.unj.cs.hw4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

class Coffee(
    val imgCoffee: Int,
    val nameCoffee: String,
    val descCoffee: String
) : Parcelable
