package com.test.simplemvvmkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.test.simplemvvmkotlin.repository.SearchActivityRepository

class SearchActivityViewModel(application:Application): AndroidViewModel(application) {

    val repository=SearchActivityRepository(application)
    val showProgress:LiveData<Boolean>

    init {
        this.showProgress=repository.showProgress
    }

}