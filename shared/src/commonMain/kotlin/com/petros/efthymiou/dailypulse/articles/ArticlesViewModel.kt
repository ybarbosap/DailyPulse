package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState = MutableStateFlow(ArticlesState(isLoading = true))
    val articlesState: StateFlow<ArticlesState> = _articlesState.asStateFlow()

    private val articlesUseCase: ArticlesUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticlesService(httpClient)
        articlesUseCase = ArticlesUseCase(service)
    }

    init { getArticles() }

    private fun getArticles() {
        vmScope.launch {
            runCatching {
                _articlesState.isLoading(true)
                articlesUseCase.fetchArticles(
                    country = "us",
                    category = "business"
                )
            }.onFailure {
                _articlesState.emitError(it.stackTraceToString())
            }.onSuccess {
                _articlesState.emitResult(it)
            }.also {
                _articlesState.isLoading(false)
            }
        }
    }
}