package com.tick.taku.example.paging3.data.repository

import com.tick.taku.example.paging3.entity.Cat

interface CatRepository {

    suspend fun cat(limit: Int, page: Int): List<Cat>

}