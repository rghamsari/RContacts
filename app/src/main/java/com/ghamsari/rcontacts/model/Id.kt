package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Id(
        @Expose
        @SerializedName("name")
    val name: String,
        @Expose
        @SerializedName("value")
    val value: String
): Serializable