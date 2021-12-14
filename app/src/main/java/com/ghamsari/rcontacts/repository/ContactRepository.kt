package com.ghamsari.rcontacts.repository

import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.network.ApiContactClient
import com.ghamsari.rcontacts.network.JsonContactsHolderApi
import io.reactivex.Observable


class ContactRepository(private val jsonContactsHolderApi: JsonContactsHolderApi) : InContactRepository{

    override fun getContact(page: String, result: String, seed: String): Observable<List<Contacts>> {

       return jsonContactsHolderApi.getContacts(page, result, seed)


    }








//    lateinit var Progressdialog : ProgressDialog
//    lateinit var contactsList :MutableLiveData<Contacts>
//    init {
//        contactsList = MutableLiveData()
//    }
//   public fun getContactsListObserver() :MutableLiveData<Contacts>{
//        return contactsList
//    }
//    fun makeApiCall(query :String){
//        val retfofitInstance = ApiContactClient.getRetfofitInstance().create(JsonContactsHolderApi::class.java)
//        retfofitInstance.getContacts("1","10","abc")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getContactListObserverRx())
//
//
//    }
//    fun getContactListObserverRx(): Observer<Contacts> {
//        return object : Observer<Contacts> {
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
    }
































//    private val onNextStub: (Contacts) -> Unit = {}
//    private val onErrorStub: (Throwable) -> Unit = {}
//    private val onCompleteStub: () -> Unit = {}
//    private fun <T : Contacts> ((T) -> Unit).asConsumer(): Consumer<T> {
//        return if (this === onNextStub) Functions.emptyConsumer() else Consumer(this)
//    }
//
//    private fun ((Throwable) -> Unit).asOnErrorConsumer(): Consumer<Throwable> {
//        return if (this === onErrorStub) Functions.ON_ERROR_MISSING else Consumer(this)
//    }
//
//    private fun (() -> Unit).asOnCompleteAction(): Action {
//        return if (this === onCompleteStub) Functions.EMPTY_ACTION else Action(this)
//    }
//
//    //////////////////////////////////////////////////////////////////////////
//  val  jsonContactsHolderApi : JsonContactsHolderApi = ApiClient.create()
// var mutableLiveData : MutableLiveData<List<Contacts>> = TODO()
//fun getContactditel ():MutableLiveData<List<Contacts>> {
//    jsonContactsHolderApi.getContacts()
//            .subscribeBy(
//                    onError: (Throwable) -> Unit = onErrorStub,
//    onComplete: () -> Unit = onCompleteStub,
//    onNext: (T) -> Unit = onNextStub
//    ): Disposable = subscribe(onNext.asConsumer(), onError.asOnErrorConsumer(), onComplete.asOnCompleteAction())
//
//}



