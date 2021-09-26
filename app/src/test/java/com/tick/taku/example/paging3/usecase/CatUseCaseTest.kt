package com.tick.taku.example.paging3.usecase

import androidx.paging.PagingSource
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat
import com.tick.taku.example.paging3.usecase.internal.CatUseCaseImpl
import kotlinx.coroutines.runBlocking
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import kotlin.test.*

class CatUseCaseTest {

    private val mockCats = listOf(
        Cat("1", "", emptyList()),
        Cat("2", "", emptyList()),
        Cat("3", "", emptyList())
    )

    private val repository: CatRepository = mock {
        onBlocking { cats(any(), any()) } doReturn Result.success(mockCats)
    }

    private val useCase: CatUseCase by lazy {
        CatUseCaseImpl(repository)
    }

    private val firstPage = 1
    private val mockLoadParams by lazy {
        PagingSource.LoadParams.Refresh(
            key = firstPage,
            loadSize = useCase.limit,
            placeholdersEnabled = true
        )
    }

    @Test
    @Throws(Exception::class)
    fun loadResult_success() = runBlocking {
        useCase.cats().load(mockLoadParams).let {
            assertTrue { it is PagingSource.LoadResult.Page }

            (it as PagingSource.LoadResult.Page).let { result ->
                result.itemsBefore
                assertEquals(result.data.size, mockCats.size)
                assertEquals(result.data.first().id, "1")

                assertNotNull(result.nextKey)
                assertEquals(result.nextKey, firstPage + 1)
                assertEquals(result.prevKey, firstPage - 1)
            }
        }
    }

    @Test
    @Throws(Exception::class)
    fun loadResult_failure() = runBlocking {
        whenever(repository.cats(any(), any())) doReturn Result.failure(mock<HttpException>())

        useCase.cats().load(mockLoadParams).let {
            assertTrue { it is PagingSource.LoadResult.Error }

            assertTrue { (it as PagingSource.LoadResult.Error).throwable is HttpException }
        }
    }
}