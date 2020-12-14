package com.test.simplemvvmkotlin.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.simplemvvmkotlin.network.model.WeatherResponse
import com.test.simplemvvmkotlin.repository.DetailActivityRepository

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val detailRepository = DetailActivityRepository(application)

    val showProgress: LiveData<Boolean>

    val response: LiveData<WeatherResponse>

    init {
        this.showProgress = detailRepository.showProgress
        this.response = detailRepository.weatherResponse
    }

    fun getWeather(woeid: Int) {
        detailRepository.searchWeather(woeid)
    }

}