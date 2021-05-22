package com.tick.taku.example.paging3.entity

import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    val image: Cat,
    val name: String,
    val description: String
)