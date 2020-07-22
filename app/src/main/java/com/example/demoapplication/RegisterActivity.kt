package com.example.demoapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapplication.database.DatabaseClient
import com.example.demoapplication.model.Person
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSubmit.setOnClickListener {
            val name = edtFullNameAdd.text.toString()
            val phone = edtPhoneAdd.text!!.toString()
            val address = edtAddressAdd.text!!.toString()
            val age = edtAgeAdd.text!!.toString()
            Thread(object :Runnable{
                override fun run() {
                    val person = Person(0,name,age,address,phone)
                    DatabaseClient.getDatabase(this@RegisterActivity).insertPerson(person)
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }).start()

        }
    }
}