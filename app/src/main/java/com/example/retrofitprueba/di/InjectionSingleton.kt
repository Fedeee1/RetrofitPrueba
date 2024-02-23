package com.example.retrofitprueba.di

import com.example.retrofitprueba.core.RetrofitClient
import com.example.retrofitprueba.data.domain.repository.remote.RemoteApiService
class InjectionSingleton {
    companion object {
        fun provideApiServices(): RemoteApiService {
            return RetrofitClient.makeRetrofitService().create(RemoteApiService::class.java)
        }
    }
}