package com.acronymmeaning.example.network

import com.acronymmeaning.example.model.Sf
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("dictionary.py")
    suspend fun getAcronymData(@Query("sf") inputType: String): Response<List<Sf>?>
}