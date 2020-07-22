package com.example.demoapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demoapplication.model.Person

@Database(entities = [Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}