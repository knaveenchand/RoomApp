package com.example.roomapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "names_table")
data class Names(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String
)