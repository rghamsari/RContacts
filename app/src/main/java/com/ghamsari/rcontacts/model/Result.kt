package com.ghamsari.rcontacts.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
        @Expose
        @SerializedName("cell")
    val cell: String,
        @Expose
        @SerializedName("dob")
    val dob: Dob,
        @Expose
        @SerializedName("email")
    val email: String,
        @Expose
        @SerializedName("gender")
    val gender: String,
        @Expose
        @SerializedName("id")
    val id: Id,
        @Expose
        @SerializedName("location")
    val location: Location,
        @Expose
        @SerializedName("login")
    val login: Login,
        @Expose
        @SerializedName("name")
    val name: Name,
        @Expose
        @SerializedName("nat")
    val nat: String,
        @Expose
        @SerializedName("phone")
    val phone: String,
        @Expose
        @SerializedName("picture")
    val picture: Picture,
        @Expose
        @SerializedName("registered")
    val registered: Registered
)