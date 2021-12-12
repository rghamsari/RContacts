package com.ghamsari.rcontacts.view

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghamsari.rcontacts.R
import com.ghamsari.rcontacts.model.Contacts
import com.ghamsari.rcontacts.utils.ContactAdapter
import com.ghamsari.rcontacts.viewmodle.ContactsViewModle
import com.ghamsari.rcontacts.viewmodle.ContactsViewModelFactory



class MainActivity : AppCompatActivity() {
lateinit var  viewModle: ContactsViewModle
lateinit var contactsRecyclerView :RecyclerView
lateinit var contactsAdapter :ContactAdapter
val contactsViewModelFactory :ContactsViewModelFactory = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        lodeData()
        initRecyclerView()

    }


    fun initRecyclerView(){
        contactsRecyclerView.findViewById<RecyclerView>(R.id.mainactivitrRecyclview)
        contactsRecyclerView.apply {
            val layoutManager =LinearLayoutManager(this@MainActivity)
            val decoration =DividerItemDecoration(applicationContext,VERTICAL)
            addItemDecoration(decoration)
            contactsAdapter =ContactAdapter()
            adapter = contactsAdapter


        }

    }


    fun lodeData(){
        viewModle =  ViewModelProvider(this, contactsViewModelFactory).get(ContactsViewModle::class.java)
        viewModle .contactsList.observe(this, Observer{
            val contact :Contacts = it!!.get(0)
            contactsAdapter.contactAdapterData(contact.results)
            contactsAdapter.notifyDataSetChanged()
        })

    }



















    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}


