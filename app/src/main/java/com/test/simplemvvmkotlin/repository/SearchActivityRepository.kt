package com.test.simplemvvmkotlin.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData

class SearchActivityRepository(application: Application) {

    val showProgress=MutableLiveData<Boolean>()

}