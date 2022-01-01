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


//<androidx.cardview.widget.CardView
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//app:layout_constraintTop_toTopOf="parent"
//app:layout_constraintLeft_toLeftOf="parent"
//app:layout_constraintRight_toRightOf="parent"
//app:cardBackgroundColor="#E2F3F3"
//app:cardCornerRadius="24dp"
//app:cardElevation="18dp"
//app:cardMaxElevation="18dp"
//android:layout_marginTop="164dp"
//android:layout_marginLeft="@dimen/contact_detil_margin"
//android:layout_marginBottom="@dimen/contact_detil_margin"
//android:layout_marginRight="@dimen/contact_detil_margin"
//>
//<androidx.constraintlayout.widget.ConstraintLayout
//android:layout_gravity="center"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//>
//
//<de.hdodenhof.circleimageview.CircleImageView
//android:layout_width="124dp"
//android:layout_height="124dp"
//android:src="@drawable/ic_action_female"
//android:layout_marginTop="-20dp"
//app:civ_border_color="#009688"
//app:civ_border_width="2dp"
//app:layout_constraintHorizontal_bias="0.498"
//app:layout_constraintLeft_toLeftOf="parent"
//app:layout_constraintRight_toRightOf="parent"
//app:layout_constraintTop_toTopOf="parent"
///>
//
//</androidx.constraintlayout.widget.ConstraintLayout>
//</androidx.cardview.widget.CardView>


