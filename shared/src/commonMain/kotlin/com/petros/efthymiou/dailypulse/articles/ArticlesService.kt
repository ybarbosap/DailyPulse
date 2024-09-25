package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.articles.ArticlesService.Settings.API_KEY
import com.petros.efthymiou.dailypulse.articles.ArticlesService.Settings.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private object Settings {
        const val API_KEY = "04f0aed7eb024d5596d3bcb0a6b1fca7"
        const val BASE_URL = "https://newsapi.org"
    }

    suspend fun fetchArticles(country: String, category: String): List<ArticleRaw> {
        val url = "$BASE_URL/v2/top-headlines" +
                "?country=$country" +
                "&category=$category" +
                "&apiKey=$API_KEY"

        val response = httpClient
            .get(url)
            .body<ArticlesResponse>()

        return response.articles
    }
}