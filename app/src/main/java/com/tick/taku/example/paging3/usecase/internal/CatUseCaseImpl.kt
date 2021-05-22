package com.tick.taku.example.paging3.usecase.internal

import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase

internal class CatUseCaseImpl(
    private val repository: CatRepository
): CatUseCase {

    override val limit: Int = 20

    override suspend fun cats(page: Int): List<Cat> = repository.cats(limit, page)

}