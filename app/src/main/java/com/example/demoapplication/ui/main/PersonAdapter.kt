package com.example.demoapplication.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R
import com.example.demoapplication.model.Person
import kotlinx.android.synthetic.main.item_person.view.*

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    private var personList = mutableListOf<Person>()
    private var onClickItemListener: OnClickItemListener? = null

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun addListPerson(personList: MutableList<Person>) {
        this.personList = personList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.itemView.tvNameItem.text = person.name
        holder.itemView.tvPhoneItem.text = person.phone

    }

    fun setOnItemClickListener(onClickItemListener: OnClickItemListener) {
        this.onClickItemListener = onClickItemListener
    }

    interface OnClickItemListener {
        fun onClickItem(position: Int)
    }
}