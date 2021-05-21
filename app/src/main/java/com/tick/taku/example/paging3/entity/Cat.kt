package com.tick.taku.example.paging3.entity

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String,
    val url: String
)