package com.tick.taku.example.paging3.data.api

import com.tick.taku.example.paging3.entity.Breed
import com.tick.taku.example.paging3.entity.Cat
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CatSearchApi {

    @Headers("x-api-key: apiKey")
    @GET("images/search")
    suspend fun cats(@Query("limit") limit: Int, @Query("page") page: Int): List<Cat>

    @Headers("x-api-key: apiKey")
    @GET("breeds")
    suspend fun breeds(@Query("limit") limit: Int, @Query("page") page: Int): List<Breed>

}