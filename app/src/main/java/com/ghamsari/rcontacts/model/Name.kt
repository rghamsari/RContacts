package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name(
        @Expose
        @SerializedName("first")
    val first: String,
        @Expose
        @SerializedName("last")
    val last: String,
        @Expose
        @SerializedName("title")
    val title: String
)