package com.tick.taku.example.paging3.data.repository.internal

import com.tick.taku.example.paging3.data.api.CatSearchApi
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat
import javax.inject.Inject

class CatRepositoryImpl @Inject internal constructor(
    private val catSearchApi: CatSearchApi
): CatRepository {

    override suspend fun cats(limit: Int, page: Int): Result<List<Cat>> =
        runCatching {
            catSearchApi.cats(limit, page)
        }

}