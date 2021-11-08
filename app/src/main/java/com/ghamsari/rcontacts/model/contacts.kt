package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class contacts(
        @Expose
        @SerializedName("info")
    val info: Info,
        @Expose
        @SerializedName("results")
    val results: List<Result>
)