package com.ghamsari.rcontacts.viewmodle

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.util.Log
import androidx.lifecycle.*
import com.ghamsari.rcontacts.repository.ContactRepository
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.observers.DefaultObserver


class ContactsViewModle :ViewModel() {

    lateinit var Progressdialog: ProgressDialog
    private lateinit var _contactsList: MutableLiveData<List<Contacts>?>
    var contactsList : LiveData<List<Contacts>?> =_contactsList
    lateinit var repository:ContactRepository

//    init {
//        contactsList = MutableLiveData()
//    }

    public fun getContactsListObserver(): LiveData<List<Contacts>?> {
        return contactsList
    }

    fun makeApiCall (page: String, result: String, seed: String){


       repository =ContactRepository (ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java))
        repository.getContact(page,result,seed)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getContactListObserverRx())


    }

    fun getContactListObserverRx(): io.reactivex.Observer<List<Contacts>> {
        return  object : io.reactivex.Observer<List<Contacts>> {
            override  fun onSubscribe(p0: Disposable) {
                Progressdialog.setMessage("Pleas Wait....")
                Progressdialog.setCancelable(false)
                Progressdialog.show()
            }

            override  fun onNext(p0: List<Contacts>) {
                _contactsList.postValue(p0!!)
            }

            @SuppressLint("NullSafeMutableLiveData")
            override fun onError(p0: Throwable) {
                _contactsList.postValue(null)
            }

            override   fun onComplete() {
                Progressdialog.dismiss()
            }




        }




    }
}





