package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Picture(
        @Expose
        @SerializedName("large")
    val large: String,
        @Expose
        @SerializedName("medium")
    val medium: String,
        @Expose
        @SerializedName("thumbnail")
    val thumbnail: String
): Serializable