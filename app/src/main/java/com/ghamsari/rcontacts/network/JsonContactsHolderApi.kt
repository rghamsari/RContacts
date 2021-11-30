package com.ghamsari.rcontacts.network

import com.ghamsari.rcontacts.model.Contacts
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface JsonContactsHolderApi {

    @GET("page")
    fun getContacts(@Query("page") Page :String , @Query ("results") Results :String, @Query ("seed") Seed :String)
    : Observable<List<Contacts>>

}