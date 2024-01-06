package com.example.daggerhiltdemo.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()

    suspend fun doNetworkCall1()
}