package com.example.roomapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NamesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNames(names: Names)

    @Query("SELECT * FROM names_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Names>>

}