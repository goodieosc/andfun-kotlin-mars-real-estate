package com.example.android.marsrealestate.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mars.udacity.com/"

////Add an instance of ScalarsConverterFactory and the BASE_URL we provided,
//// then call build() to create the Retrofit object
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()
//
////Create a MarsApiService interface,
//// and define a getProperties() method to request the JSON response string.
//interface MarsApiService {
//
//    //Annotate the method with @GET, specifying the endpoint for the JSON real estate response,
//    // and create the Retrofit Call object that will start the HTTP request.
//    @GET("realestate")
//    fun getProperties():
//            Call<String>
//}
//
////Passing in the service API you just defined, create a public object called MarsApi
//// to expose the Retrofit service to the rest of the app:
//object MarsApi {
//    val retrofitService : MarsApiService by lazy {
//        retrofit.create(MarsApiService::class.java)
//    }
//}