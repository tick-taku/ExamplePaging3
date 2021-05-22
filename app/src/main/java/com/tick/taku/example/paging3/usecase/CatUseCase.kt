package com.tick.taku.example.paging3.usecase

import androidx.paging.PagingData
import com.tick.taku.example.paging3.entity.Cat
import kotlinx.coroutines.flow.Flow

interface CatUseCase {

    val limit: Int

    fun cats(page: Int): Flow<PagingData<Cat>>

}