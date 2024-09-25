package com.petros.efthymiou.dailypulse.articles

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleRaw>
)

