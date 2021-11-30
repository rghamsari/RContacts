package com.ghamsari.rcontacts.viewmodle

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import com.ghamsari.rcontacts.repository.ContactRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers.io


class ContactsViewModle :ViewModel() {
   val repository:ContactRepository = TODO()
   lateinit var mContacts : LiveData<List<Contacts>>
fun ContactsViewModle{

   return repository.getContactsListObserver().observe(this , Observer<Contacts>{
    if (it!= null){}
        else{

        }
    })
}





//    lateinit var Progressdialog : ProgressDialog
//    lateinit var contactsList :MutableLiveData<Contacts>
//    init {
//        contactsList = MutableLiveData()
//    }
//    fun getContactsListObserver() :MutableLiveData<Contacts>{
//        return contactsList
//    }
//    fun makeApiCall(query :String){
//        val retfofitInstance = ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java)
//        retfofitInstance.getContacts("1","10","abc")
//                .subscribeOn(Scheduler.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getContactListObserverRx())
//
//
//    }
//    fun getContactListObserverRx(): Observer<Contacts>{
//        return object : Observer<Contacts>{
//            override fun onSubscribe(d: Disposable?) {
//                Progressdialog.setMessage("Pleas Wait....")
//                Progressdialog.setCancelable(false)
//                Progressdialog.show()
//            }
//
//            override fun onNext(value: Contacts?) {
//                contactsList.postValue(value!!)
//            }
//
//            @SuppressLint("NullSafeMutableLiveData")
//            override fun onError(e: Throwable?) {
//                contactsList.postValue(null)
//            }
//
//            override fun onComplete() {
//                Progressdialog.dismiss()
//            }
//
//
//        }
//    }
}


