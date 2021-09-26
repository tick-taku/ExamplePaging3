package com.tick.taku.example.paging3.usecase.internal

import com.tick.taku.example.paging3.CatPagingSource
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.usecase.CatUseCase

internal class CatUseCaseImpl(
    private val repository: CatRepository
): CatUseCase {

    override val limit: Int = 20

    override fun cats(page: Int): CatPagingSource = CatPagingSource(repository, limit)

}