package com.example.daggerhiltdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltdemo.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    init {

    }


    fun temp() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.doNetworkCall()
            }
        }
    }
}