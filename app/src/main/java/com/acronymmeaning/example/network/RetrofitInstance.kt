package com.acronymmeaning.example.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    fun getRetrofitService(): RetrofitService? {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.nactem.ac.uk/software/acromine/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitService::class.java)
    }
}