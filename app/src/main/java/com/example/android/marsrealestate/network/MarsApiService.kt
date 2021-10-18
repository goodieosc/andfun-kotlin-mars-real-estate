package com.example.android.marsrealestate.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mars.udacity.com/"

//use the Moshi Builder to create a Moshi object with the KotlinJsonAdapterFactory:
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Add an instance of ScalarsConverterFactory and the BASE_URL we provided,
// then call build() to create the Retrofit object
private val retrofit = Retrofit.Builder()
    //.addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))  //change the ConverterFactory to a MoshiConverterFactory with our moshi Object:
    .baseUrl(BASE_URL)
    .build()

//Create a MarsApiService interface,
// and define a getProperties() method to request the JSON response string.
interface MarsApiService {

    //Annotate the method with @GET, specifying the endpoint for the JSON real estate response,
    // and create the Retrofit Call object that will start the HTTP request.
    @GET("realestate")
    suspend fun getProperties(): List<MarsProperty>
    //fun getProperties():
            //Call<String>
            //Call<List<MarsProperty>>

}

//Passing in the service API you just defined, create a public object called MarsApi
// to expose the Retrofit service to the rest of the app:
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

