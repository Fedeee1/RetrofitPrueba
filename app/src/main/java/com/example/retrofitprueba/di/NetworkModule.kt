package com.example.retrofitprueba.di


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