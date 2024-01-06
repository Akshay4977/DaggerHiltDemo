package com.example.daggerhiltdemo.di

import android.app.Application
import android.util.Log
import com.example.daggerhiltdemo.data.remote.MyApi
import com.example.daggerhiltdemo.data.repository.MyRepositoryImpl
import com.example.daggerhiltdemo.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepo(api: MyApi, application: Application): MyRepository{
        Log.e("inside","here")
        return  MyRepositoryImpl(api, application)
    }

}