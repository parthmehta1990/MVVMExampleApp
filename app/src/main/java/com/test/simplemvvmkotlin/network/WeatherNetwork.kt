package com.test.simplemvvmkotlin.network

import com.test.simplemvvmkotlin.network.model.Location
import com.test.simplemvvmkotlin.network.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL="https://www.metaweather.com/api/location/"

interface WeatherNetwork {

    @GET("search/?")
    fun getLocation(@Query("query") searchString:String): Call<List<Location>>

//to send data in path/url directly after base url / use the path parameter
    @GET("{woeid}")
    fun getWeather(@Path("woeid") woeid:Int): Call<WeatherResponse>

}