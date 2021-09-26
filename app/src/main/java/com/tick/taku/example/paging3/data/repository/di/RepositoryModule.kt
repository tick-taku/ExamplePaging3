package com.tick.taku.example.paging3.data.repository.di

import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.data.repository.internal.CatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCatRepository(impl: CatRepositoryImpl): CatRepository

}