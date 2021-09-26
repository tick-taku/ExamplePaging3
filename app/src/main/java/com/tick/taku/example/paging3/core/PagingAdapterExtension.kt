package com.tick.taku.example.paging3.core

import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

fun <T : Any, VH : RecyclerView.ViewHolder> PagingDataAdapter<T, VH>.andRefreshable(
    swipeRefreshLayout: SwipeRefreshLayout
) = apply {
    addLoadStateListener {
        swipeRefreshLayout.isRefreshing = it.refresh is LoadState.Loading
    }
    swipeRefreshLayout.setOnRefreshListener {
        refresh()
    }
}