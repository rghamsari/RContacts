package com.ghamsari.rcontacts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ghamsari.rcontacts.R
import com.ghamsari.rcontacts.model.Result
import android.content.Intent
import android.widget.ImageView
import com.ghamsari.rcontacts.utils.ContactAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.io.Serializable


class ContactsDetils : AppCompatActivity() {
    lateinit var firstName :TextView
    lateinit var lastName :TextView
    lateinit var phonNumber :TextView
    lateinit var email :TextView
    lateinit var profile : CircleImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_detils)
        intializItemView()
        val contactDetil =
            intent.getSerializableExtra(ContactAdapter.viewHolder.CONTEACT_KEY) as? Result
        firstName.text = contactDetil!!.name.first
        lastName.text = contactDetil!!.name.last
        phonNumber.text = contactDetil!!.phone
        email.text = contactDetil!!.email
        if (contactDetil.gender.equals("male"))
        {
            Picasso.with(this).load(R.drawable.ic_action_man).into(profile)
        }else{
            Picasso.with(this).load(R.drawable.ic_action_female).into(profile)
        }


    }
    fun intializItemView(){
        firstName =findViewById(R.id.first_name)
        lastName =findViewById(R.id.last_name)
        phonNumber =findViewById(R.id.phonenumber)
        email=findViewById(R.id.email)
        profile = findViewById(R.id.image_profile)

    }
}