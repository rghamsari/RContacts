package com.ghamsari.rcontacts.viewmodle

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.ghamsari.rcontacts.repository.ContactRepository
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import com.ghamsari.rcontacts.utils.CustomProgressDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.observers.DefaultObserver


class ContactsViewModle :ViewModel() {


    private lateinit var _contactsList: MutableLiveData<List<Contacts>?>
    var contactsList : LiveData<List<Contacts>?> =_contactsList

    private lateinit var _customProgressDialog: MutableLiveData<List<Boolean>?>
    var customProgressDialog : LiveData<List<Boolean>?> =_customProgressDialog

    lateinit var repository:ContactRepository
    lateinit var Progressdialog :CustomProgressDialog

//    init {
//        contactsList = MutableLiveData()
//    }

    public fun getContactsListObserver(): LiveData<List<Contacts>?> {
        return contactsList
    }
    public fun getcustomProgressDialogObserver(): LiveData<List<Boolean>?> {
        return customProgressDialog
    }

    fun makeApiCall (page: String, result: String, seed: String){

       repository =ContactRepository (ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java))
        repository.getContact(page,result,seed)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getContactListObserverRx())

    }

//    fun makeCustomDialoge(context: Context , title :String){
//        repository =ContactRepository (ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java))
//
//        Progressdialog.show(context)
//    .subscribeOn(Schedulers.io())
//    .observeOn(AndroidSchedulers.mainThread())
//    .subscribe(getProgressDialogObserver(context,title))
//
//    }

    fun getContactListObserverRx(): io.reactivex.Observer<List<Contacts>> {
        return  object : io.reactivex.Observer<List<Contacts>> {
            override  fun onSubscribe(p0: Disposable) {
            _customProgressDialog.postValue(listOf(true))
            }

            override  fun onNext(p0: List<Contacts>) {
                _contactsList.postValue(p0!!)
            }

            @SuppressLint("NullSafeMutableLiveData")
            override fun onError(p0: Throwable) {
                _contactsList.postValue(null)
            }

            override   fun onComplete() {
                _customProgressDialog.postValue(listOf(false))
            }
        }


    }
//    fun getProgressDialogObserver(context: Context ,title: String):io.reactivex.Observer<List<CustomProgressDialog>>{
//        return object :io.reactivex.Observer<List<CustomProgressDialog>>{
//            override fun onSubscribe(d: Disposable) {
//                Progressdialog.show(context,title)
//            }
//
//            override fun onNext(t: List<CustomProgressDialog>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onError(e: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onComplete() {
//               Progressdialog.dissmis()
//            }
//        }
//
//    }
}





