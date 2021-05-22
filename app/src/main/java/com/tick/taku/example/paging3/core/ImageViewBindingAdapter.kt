package com.tick.taku.example.paging3.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.CachePolicy

@BindingAdapter("load", "cachePolicy", requireAll = false)
fun ImageView.loadImage(url: String?, diskCachePolicy: CachePolicy = CachePolicy.DISABLED) {
    url?.takeIf { it.isNotEmpty() }?.let {
        load(it) {
            diskCachePolicy(diskCachePolicy)
        }
    }
}