package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Street(
        @Expose
        @SerializedName("name")
    val name: String,
        @Expose
        @SerializedName("number")
    val number: Int
): Serializable