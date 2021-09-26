package com.tick.taku.example.paging3.usecase.di

import com.tick.taku.example.paging3.usecase.CatUseCase
import com.tick.taku.example.paging3.usecase.internal.CatUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindCatUseCase(impl: CatUseCaseImpl): CatUseCase

}