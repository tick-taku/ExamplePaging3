package com.tick.taku.example.paging3.core

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("progressColor")
fun SwipeRefreshLayout.setProgressColor(color: Int) {
    setColorSchemeColors(color)
}