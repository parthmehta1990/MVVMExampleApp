package com.test.simplemvvmkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.simplemvvmkotlin.network.model.Location
import com.test.simplemvvmkotlin.repository.SearchActivityRepository

class SearchActivityViewModel(application:Application): AndroidViewModel(application) {

    //Make repository object to private to hide/restrict it's visibility
    private val repository=SearchActivityRepository(application)
    val showProgress:LiveData<Boolean>

    val locationList:LiveData<List<Location>>

    init {
        this.showProgress=repository.showProgress
        this.locationList=repository.locationList
    }

    fun changeState(){
        repository.changeState()
    }

    fun searchLocation(searchString: String)
    {
        repository.searchLocation(searchString)
    }

}