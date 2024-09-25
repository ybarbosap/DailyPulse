package com.petros.efthymiou.dailypulse.articles

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

fun MutableStateFlow<ArticlesState>.isLoading(isLoading: Boolean) {
    update { it.copy(isLoading = isLoading) }
}

fun MutableStateFlow<ArticlesState>.emitResult(list: List<Article>) {
    update { it.copy(articles = list) }
}

fun MutableStateFlow<ArticlesState>.emitError(message: String) {
    update { it.copy(error = message) }
    update { it.copy(error = null) }
}