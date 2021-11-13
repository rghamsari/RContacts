package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(
        @Expose
        @SerializedName("city")
    val city: String,
        @Expose
        @SerializedName("coordinates")
    val coordinates: Coordinates,
        @Expose
        @SerializedName("country")
    val country: String,
        @Expose
        @SerializedName("postcode")
    val postcode: Any,
        @Expose
        @SerializedName("state")
    val state: String,
        @Expose
        @SerializedName("street")
    val street: Street,
        @Expose
        @SerializedName("timezone")
    val timezone: Timezone
)