package com.tick.taku.example.paging3.gateway.di

import com.tick.taku.example.paging3.gateway.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GatewayModule {

    @Provides
    @Singleton
    fun provideApiClient(): ApiClient = ApiClient()

}