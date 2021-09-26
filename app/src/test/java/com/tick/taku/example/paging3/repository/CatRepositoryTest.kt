package com.tick.taku.example.paging3.repository

import com.tick.taku.example.paging3.data.api.CatSearchApi
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.data.repository.internal.CatRepositoryImpl
import com.tick.taku.example.paging3.entity.Cat
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.mockito.kotlin.*
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CatRepositoryTest {

    private val mockCat: Cat = Cat(
        id = "id",
        url = "imageUrl",
        breeds = emptyList()
    )

    private val catSearchApi: CatSearchApi = mock {
        onBlocking { cats(any(), any()) } doReturn listOf(mockCat)
    }

    private val repository: CatRepository by lazy {
        CatRepositoryImpl(catSearchApi)
    }

    @Test
    @Throws(Exception::class)
    fun loadCats_success() = runBlocking {
        repository.cats(20, 1).let {
            assertTrue { it.isSuccess }
            assertNotNull(it.getOrNull())
            assertTrue { it.getOrNull()!!.isNotEmpty() }
        }
    }

    @Test
    @Throws(Exception::class)
    fun loadCats_failure() = runBlocking {
        whenever(catSearchApi.cats(any(), any())) doThrow RuntimeException()

        repository.cats(20, 1).let {
            assertTrue { it.isFailure }
            assertNull(it.getOrNull())
            assertNotNull(it.exceptionOrNull())
            assertTrue { it.exceptionOrNull() is RuntimeException }
        }
    }
}