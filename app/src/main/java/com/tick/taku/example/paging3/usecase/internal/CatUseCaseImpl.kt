package com.tick.taku.example.paging3.usecase.internal

import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Breed
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.CatUseCase

internal class CatUseCaseImpl(
    private val repository: CatRepository
): CatUseCase {

    override val limit: Int = 20

    override suspend fun cate(page: Int): List<Cat> = repository.cat(limit, page)

    override suspend fun breeds(page: Int): List<Breed> = repository.breeds(limit, page)

}