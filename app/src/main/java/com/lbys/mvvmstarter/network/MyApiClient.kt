package com.lbys.mvvmstarter.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object MyApiClient {

    @Provides
    fun provideMyApiService(): MyApiService {
        return Retrofit.Builder()
            .baseUrl("https://imdb-api.com/en/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApiService::class.java)
    }
}
