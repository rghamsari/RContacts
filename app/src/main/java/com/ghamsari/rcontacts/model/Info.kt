package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Info(
        @Expose
        @SerializedName("page")
    val page: Int,
        @Expose
        @SerializedName("results")
    val results: Int,
        @Expose
        @SerializedName("seed")
    val seed: String,
        @Expose
        @SerializedName("version")
    val version: String
): Serializable