package com.example.demoapplication.database

import android.content.Context
import androidx.room.Room
import com.example.demoapplication.model.Person

class DatabaseClient private constructor(context: Context) {
    private var database: AppDatabase? = null

    init {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "PersonData").build()
    }

    companion object {
        private var INSTANCE: DatabaseClient? = null
        fun getDatabase(context: Context): DatabaseClient {
            if (INSTANCE == null) {
                INSTANCE = DatabaseClient(context)
            }
            return INSTANCE!!
        }
    }

    fun getAllListPerson(): MutableList<Person> {
        return database!!.personDao().getAllListPerson()
    }

    fun insertPerson(person: Person) {
        database!!.personDao().insertPerson(person)
    }

    fun deletePerson(person: Person) {
        database!!.personDao().deletePerson(person)
    }

    fun updatePerson(person: Person) {
        database!!.personDao().updatePerson(person)
    }
}