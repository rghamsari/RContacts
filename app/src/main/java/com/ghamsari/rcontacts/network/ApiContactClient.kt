package com.ghamsari.rcontacts.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiContactClient {
    companion object {
        val BaseUrl = "https://randomuser.me/api/"


    public fun getRetfofitInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
}
}