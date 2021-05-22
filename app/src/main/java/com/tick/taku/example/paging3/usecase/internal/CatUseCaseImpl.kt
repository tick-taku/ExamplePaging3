package com.tick.taku.example.paging3.usecase.internal

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tick.taku.example.paging3.CatPagingSource
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase
import kotlinx.coroutines.flow.Flow

internal class CatUseCaseImpl(
    private val repository: CatRepository
): CatUseCase {

    override val limit: Int = 20

    override fun cats(page: Int): Flow<PagingData<Cat>> =
        Pager(PagingConfig(pageSize = limit, initialLoadSize = limit)) {
            CatPagingSource(repository, limit)
        }.flow

}