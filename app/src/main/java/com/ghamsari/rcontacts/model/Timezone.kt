package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Timezone(
        @Expose
        @SerializedName("description")
    val description: String,
        @Expose
        @SerializedName("offset")
    val offset: String
)