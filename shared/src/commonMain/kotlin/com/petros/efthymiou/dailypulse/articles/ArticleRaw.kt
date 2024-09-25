package com.petros.efthymiou.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val author: String?,
    val title: String?,
    @SerialName("description")
    val desc: String?,
    @SerialName("publishedAt")
    val date: String?,
    @SerialName("urlToImage")
    val imageUrl: String?
)