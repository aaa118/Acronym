package com.acronymmeaning.example.repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.acronymmeaning.example.model.Sf
import com.acronymmeaning.example.network.RetrofitInstance
import kotlinx.coroutines.*
import retrofit2.Response

open class MainRepository(private val context: Context) {
    suspend fun getAcronymDataResponse(inputText: String): Response<List<Sf>?>? =
        withContext(Dispatchers.IO) {
            val retrofitInstance = RetrofitInstance()
            try {
                return@withContext retrofitInstance.getRetrofitService()?.getAcronymData(inputText)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Network Error, Please try again later",
                        Toast.LENGTH_LONG
                    ).show()
                }
                Log.e(TAG, "getAcronymDataResponse: Exception ${e.localizedMessage}")
                return@withContext null
            }
        }

    companion object {
        private const val TAG = "Repository"
    }
}