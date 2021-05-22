package com.tick.taku.example.paging3.usecase

import com.tick.taku.example.paging3.entity.Cat

interface CatUseCase {

    val limit: Int

    suspend fun cate(page: Int): List<Cat>

}