package com.test.simplemvvmkotlin.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.test.simplemvvmkotlin.network.BASE_URL
import com.test.simplemvvmkotlin.network.WeatherNetwork
import com.test.simplemvvmkotlin.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivityRepository(val application: Application) {

    val showProgress=MutableLiveData<Boolean>()

    val weatherResponse = MutableLiveData<WeatherResponse>()

    fun searchWeather(worid: Int)
    {
        showProgress.value =true

        //Network call
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(WeatherNetwork::class.java)

        service.getWeather(worid).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {

                //hide progressbar
                showProgress.value =false

                //Handing the response
                weatherResponse.value=response.body()

            }

            override fun onFailure(
                call: Call<WeatherResponse>,
                t: Throwable
            ) {
                //hide Progressbar
                showProgress.value =false
                //Make application parameter as val to access in Toast message
                Toast.makeText(application,"Error occured while calling api", Toast.LENGTH_SHORT).show()


            }

        })

    }

}