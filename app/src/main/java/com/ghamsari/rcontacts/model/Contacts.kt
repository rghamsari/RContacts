package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Contacts(
        @Expose
        @SerializedName("info")
    val info: Info,
        @Expose
        @SerializedName("results")
    val results: List<Result>
): Serializable