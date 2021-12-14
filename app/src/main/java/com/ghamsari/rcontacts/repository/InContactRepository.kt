package com.ghamsari.rcontacts.repository

import com.ghamsari.rcontacts.model.Contacts
import io.reactivex.Observable

interface InContactRepository {
    fun getContact(Page :String , Result :String , Seed :String) : Observable<List<Contacts>>
}