package com.ghamsari.rcontacts.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ghamsari.rcontacts.R
import com.ghamsari.rcontacts.model.Result
import com.ghamsari.rcontacts.view.ContactsDetils
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class contactAdapter(private val dataSet :List<Result>) :RecyclerView.Adapter<contactAdapter.viewHolder>() {

    class viewHolder(view :View) :RecyclerView.ViewHolder(view) , View.OnClickListener{
         var view: View = view
        private var result :Result? = null
       val firstName :TextView
       val lastName :TextView
       val gender : TextView
       val imagegender :CircleImageView
       val phoneNumber :TextView
       init {
           view.setOnClickListener(this)
           firstName =view.findViewById(R.id.first_name)
           lastName =view.findViewById(R.id.last_name)
            gender =view.findViewById(R.id.title)
           imagegender =view.findViewById(R.id.image_gender)
           phoneNumber =view.findViewById(R.id.phonenumber)
       }
        companion object {

            private val CONTEACT_KEY = "CONTEACT"
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val showPhotoIntent = Intent(context, ContactsDetils::class.java)
            showPhotoIntent.putExtra (CONTEACT_KEY, result )
            context.startActivity(showPhotoIntent)
        }
        fun bindContact(result: Result ){
            this.result = result

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactAdapter.viewHolder {

        val view =LayoutInflater.from(parent.context).inflate(R.layout.contacts_recyclerview_item,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: contactAdapter.viewHolder, position: Int) {
        val Result =dataSet[position]
        holder.bindContact(Result)
        holder.firstName.text=Result.name.first
        holder.lastName.text=Result.name.last
        holder.phoneNumber.text=Result.phone
        holder.gender.text =Result.gender
        if (Result.gender.equals("Mr")){

            Picasso.with(holder.view.context).load(R.drawable.ic_action_man).into(holder.imagegender)

        }else{

            Picasso.with(holder.view.context).load(R.drawable.ic_action_female).into(holder.imagegender)
        }


//            Picasso.with(view.context).load(photo.url).into(view.itemImage)
//            view.itemDate.text = photo.humanDate
//            view.itemDescription.text = photo.explanation

    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }
}