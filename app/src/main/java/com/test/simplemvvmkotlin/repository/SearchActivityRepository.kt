package com.test.simplemvvmkotlin.repository

import android.app.Application
import android.location.Location
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.test.simplemvvmkotlin.network.BASE_URL
import com.test.simplemvvmkotlin.network.WeatherNetwork
import com.test.simplemvvmkotlin.network.model.WeatherResponse
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(val application: Application) {

    val showProgress=MutableLiveData<Boolean>()
    val locationList=MutableLiveData<List<com.test.simplemvvmkotlin.network.model.Location>>()

    fun changeState(){
        showProgress.value = !(showProgress.value!=null && showProgress.value!!)
    }

    fun searchLocation(searchString: String)
    {
        showProgress.value =true

        //Network call
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(WeatherNetwork::class.java)

        service.getLocation(searchString).enqueue(object :Callback<List<com.test.simplemvvmkotlin.network.model.Location>>{
            override fun onResponse(
                call: Call<List<com.test.simplemvvmkotlin.network.model.Location>>,
                response: Response<List<com.test.simplemvvmkotlin.network.model.Location>>
            ) {

                //Handing the response and storing it in mutable live data
                locationList.value=response.body()

                //hide progressbar
                showProgress.value =false

            }

            override fun onFailure(
                call: Call<List<com.test.simplemvvmkotlin.network.model.Location>>,
                t: Throwable
            ) {
                //hide Progressbar
                showProgress.value =false
                //Make application parameter as val to access in Toast message
                Toast.makeText(application,"Error occured while calling api",Toast.LENGTH_SHORT).show()


            }

        })

    }

}