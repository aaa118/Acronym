package com.acronymmeaning.example.viewmodels

import android.content.Context
import com.acronymmeaning.example.repo.MainRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class UserInputViewModelTest {
    lateinit var userInputViewModel: UserInputViewModel

    private var mockContext: Context = mock { }
    var mockMainRepository: MainRepository = mock { }

    @Before
    fun setUp() {
        userInputViewModel = UserInputViewModel()
    }

    @Test
    fun should_CallGetAcronymResponse() {
        userInputViewModel.getAcronymDetailsLiveDataFromNetwork(mockContext, "lg")
        runBlocking {
            verify(mockMainRepository, times(1)).getAcronymDataResponse("lg")
        }
    }
}