package com.ghamsari.rcontacts.network

import com.ghamsari.rcontacts.model.contacts
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface jsonContactsHolderApi {

    @GET("Content")
    fun getContacts() : Observable<List<contacts>>

}