package com.tick.taku.example.paging3.gateway

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ApiClient {

    companion object {
        private const val BASE_URL = "https://api.thecatapi.com/v1/"
        private const val TIME_OUT_MILLIS = 2000L
    }

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpClient())
            .addConverterFactory(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .build()

    private fun provideHttpClient() =
        OkHttpClient.Builder()
            .callTimeout(TIME_OUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(TIME_OUT_MILLIS, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

}