package com.tick.taku.example.paging3.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.request.CachePolicy

@BindingAdapter("load")
fun ImageView.loadImage(url: String?) {
    url?.takeIf { it.isNotEmpty() }?.let {
        load(it) {
            diskCachePolicy(CachePolicy.DISABLED)
        }
    }
}