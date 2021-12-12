package com.ghamsari.rcontacts.viewmodle

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.lifecycle.*
import com.ghamsari.rcontacts.repository.ContactRepository
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ContactsViewModle(Repository :ContactRepository) :ViewModel() {

    lateinit var mContacts: LiveData<List<Contacts>>
    lateinit var Progressdialog: ProgressDialog
    private lateinit var _contactsList: MutableLiveData<List<Contacts>?>
    var contactsList : MutableLiveData<List<Contacts>?> =_contactsList

    init {
        contactsList = MutableLiveData()
    }

    public fun getContactsListObserver(): MutableLiveData<List<Contacts>?> {
        return contactsList
    }

    fun makeApiCall (query:String){
        val retfofitInstance =
            ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java)
        retfofitInstance.getContacts("1", "10", "abc")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getContactListObserverRx())


    }

    fun getContactListObserverRx(): Observer<List<Contacts>> {
        return  Observer<List<Contacts>> {
            fun onSubscribe(d: Disposable?) {
                Progressdialog.setMessage("Pleas Wait....")
                Progressdialog.setCancelable(false)
                Progressdialog.show()
            }

             fun onNext(value: Contacts?) {
                contactsList.postValue(listOf(value!!))
            }

            @SuppressLint("NullSafeMutableLiveData")
             fun onError(e: Throwable?) {
                contactsList.postValue(null)
            }

             fun onComplete() {
                Progressdialog.dismiss()
            }


        }


fun contactsViewModle() : LiveData<List<Contacts>> {
    getContactsListObserver().also { mContacts = it }
    return mContacts

}

    }
}





