package com.tick.taku.example.paging3.data.api.di

import com.tick.taku.example.paging3.data.api.CatSearchApi
import com.tick.taku.example.paging3.gateway.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideCatSearchApi(apiClient: ApiClient): CatSearchApi {
        return apiClient.provideRetrofit().create(CatSearchApi::class.java)
    }

}