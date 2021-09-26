package com.tick.taku.example.paging3.usecase

import com.tick.taku.example.paging3.CatPagingSource

interface CatUseCase {

    val limit: Int

    fun cats(page: Int): CatPagingSource

}