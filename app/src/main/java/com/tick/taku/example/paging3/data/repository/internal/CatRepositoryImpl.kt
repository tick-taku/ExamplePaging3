package com.tick.taku.example.paging3.data.repository.internal

import com.tick.taku.example.paging3.data.api.CatSearchApi
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.gateway.ApiClient

internal class CatRepositoryImpl(
    private val apiClient: ApiClient
): CatRepository {

    override suspend fun cats(limit: Int, page: Int): List<Cat> =
        apiClient.provideRetrofit().create(CatSearchApi::class.java)
            .cats(limit, page)

}