package com.acronymmeaning.example.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acronymmeaning.example.model.Sf
import com.acronymmeaning.example.repo.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserInputViewModel : ViewModel() {
    var acronymDetailsLiveData: MutableLiveData<List<Sf>> = MutableLiveData<List<Sf>>()
    private lateinit var mainRepository: MainRepository

    // Unit test Added for this method
    fun getAcronymDetailsLiveDataFromNetwork(context: Context, inputText: String) {
        mainRepository = MainRepository(context)
        val coroutineScope = CoroutineScope(Dispatchers.IO + Job())
        coroutineScope.launch {

            val response = mainRepository.getAcronymDataResponse(inputText)
            if (response != null) {
                if (response.isSuccessful) {
                    Log.i(TAG, "getAcronymDetailsLiveDataFromNetwork response: ${response.body()}")
                    acronymDetailsLiveData.postValue(response.body())
                }
            } else {
                Log.i(TAG, "Error: ")
            }
        }
    }

    companion object {
        private const val TAG = "UserInputViewModel"
    }
}