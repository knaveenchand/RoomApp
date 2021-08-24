package com.example.roomapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NamesViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Names>>
    private val repository: NamesRepository

    init {
        val namesDao = NamesDatabase.getDatabase(application).namesDao()
        repository = NamesRepository(namesDao)
        readAllData = repository.readAllData
    }

    fun addNames(names: Names){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNames(names)
        }
    }

}