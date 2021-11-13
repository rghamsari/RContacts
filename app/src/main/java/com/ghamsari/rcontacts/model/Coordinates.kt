package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates(
        @Expose
        @SerializedName("latitude")
    val latitude: String,
        @Expose
        @SerializedName("longitude")
    val longitude: String
)