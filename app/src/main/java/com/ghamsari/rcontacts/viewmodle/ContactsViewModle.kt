package com.ghamsari.rcontacts.viewmodle

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.*
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import com.ghamsari.rcontacts.repository.ContactRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers.io


class ContactsViewModle() :ViewModel() {
    val repository:ContactRepository = TODO()
   lateinit var mContacts : LiveData<List<Contacts>>

fun ContactsViewModle() : LiveData<List<Contacts>> {
    repository.getContactsListObserver().also { mContacts = it }
    return mContacts



//    repository.getContactsListObserver().observe(context, Observer<Contacts> {
//
//
//    }).also { mContacts = it }

 //  repository.getContactsListObserver().also { it -> mContacts = it }

//   return repository.getContactsListObserver().observe(context , Observer<Contacts>{
//    if (it!= null){}
//        else{
//
//        }
//    })
}

}



