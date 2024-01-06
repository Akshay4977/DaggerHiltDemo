package com.example.daggerhiltdemo.data.repository

import android.app.Application
import com.example.daggerhiltdemo.R
import com.example.daggerhiltdemo.data.remote.MyApi
import com.example.daggerhiltdemo.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {
        println("doNetworkCall")
        api.doNetworkCall()
    }

    override suspend fun doNetworkCall1() {
        println("doNetworkCall1")
        api.doNetworkCall()
    }
}