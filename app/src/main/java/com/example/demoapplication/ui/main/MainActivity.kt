package com.example.demoapplication.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R
import com.example.demoapplication.RegisterActivity
import com.example.demoapplication.database.DatabaseClient
import com.example.demoapplication.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: PersonAdapter
    private var personList = mutableListOf<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = PersonAdapter()
        recyclerViewMain.adapter = mAdapter
        recyclerViewMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        addPerson()
        fab.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent,1)
        }
    }

    private fun addPerson() {
        Thread(Runnable {
            personList = DatabaseClient.getDatabase(this@MainActivity).getAllListPerson()
            runOnUiThread {
                mAdapter.addListPerson(personList)
                Log.d("TAG", "addPerson: " + personList[0].address)
            }
        }).start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            addPerson()
        }
    }
}