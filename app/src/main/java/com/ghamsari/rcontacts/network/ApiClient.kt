package com.ghamsari.rcontacts.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var Base_Url :String ="https://randomuser.me/api/"

    fun create() : JsonContactsHolderApi {

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Base_Url)
                .build()
        return retrofit.create(JsonContactsHolderApi::class.java)

    }
}