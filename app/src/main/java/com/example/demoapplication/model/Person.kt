package com.example.demoapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "age")
    var age: String,
    @ColumnInfo(name = "address")
    var address: String,
    @ColumnInfo(name = "phone")
    var phone: String
)