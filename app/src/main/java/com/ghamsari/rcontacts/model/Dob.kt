package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dob(
        @Expose
        @SerializedName("age")
    val age: Int,
        @Expose
        @SerializedName("date")
    val date: String
)