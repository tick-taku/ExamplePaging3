package com.tick.taku.example.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat

class CatPagingSource(
    private val repository: CatRepository,
    private val limit: Int
): PagingSource<Int, Cat>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val nextKey = params.key ?: 1
        return runCatching { repository.cats(limit, nextKey) }
            .fold(
                onSuccess = {
                    LoadResult.Page(
                        data = it,
                        prevKey = null,
                        nextKey = nextKey.plus(1).takeIf { _ -> it.isNotEmpty() }
                    )
                },
                onFailure = {
                    LoadResult.Error(it)
                }
            )
    }

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

}