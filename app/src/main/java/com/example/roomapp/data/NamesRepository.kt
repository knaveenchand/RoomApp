package com.example.roomapp.data

import androidx.lifecycle.LiveData

class NamesRepository(private val namesDao: NamesDao) {

    val readAllData: LiveData<List<Names>> = namesDao.readAllData()

    suspend fun addNames(names: Names){
        namesDao.addNames(names)
    }

}