package com.example.demoapplication.database

import androidx.room.*
import com.example.demoapplication.model.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    fun getAllListPerson(): MutableList<Person>

    @Insert
    fun insertPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Update
    fun updatePerson(person: Person)
}