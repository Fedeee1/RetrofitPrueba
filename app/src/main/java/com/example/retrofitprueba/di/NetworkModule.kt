package com.example.retrofitprueba.di


import com.example.retrofitprueba.BuildConfig.BASE_URL
import com.example.retrofitprueba.data.domain.repository.remote.PokemonApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun providePokemonApiClient(retrofit: Retrofit): PokemonApiClient {
//        return retrofit.create(PokemonApiClient::class.java)
//    }
//
//}