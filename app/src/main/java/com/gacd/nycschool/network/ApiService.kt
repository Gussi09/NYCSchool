package com.gacd.nycschool.network

import com.gacd.nycschool.model.Details
import com.gacd.nycschool.model.School
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    //Get ApiService to all schools names and description
    @GET("s3k6-pzi2.json")
    suspend fun getSchool() : List<School>

    //Get ApiService to see details about especific school SAT AVG Scores
    @GET("f9bf-2cp4.json")
    suspend fun getDetails() : List<Details>

    companion object{
        var apiService: ApiService? = null
        fun getInstance() : ApiService{
            if(apiService == null){
                //API Base URL to Get Requests
                apiService = Retrofit.Builder()
                    .baseUrl("https://data.cityofnewyork.us/resource/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}