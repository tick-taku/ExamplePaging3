package com.tick.taku.example.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tick.taku.example.paging3.data.repository.CatRepository
import com.tick.taku.example.paging3.entity.Cat

class CatPagingSource(
    private val repository: CatRepository
): PagingSource<Int, Cat>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val currentKey = params.key ?: 1
        return repository.cats(params.loadSize, currentKey)
            .fold(
                onSuccess = {
                    LoadResult.Page(
                        data = it,
                        prevKey = (currentKey - 1).takeIf { key -> key > 0 },
                        nextKey = (currentKey + 1).takeIf { _ -> it.isNotEmpty() }
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