package com.petros.efthymiou.dailypulse.articles

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val articleService: ArticlesService) {

    suspend fun fetchArticles(country: String, category: String): List<Article> {
        return articleService
            .fetchArticles(country, category)
            .map {
                Article(
                    title = it.title.orEmpty(),
                    date = it.date.dateFormat(),
                    desc = it.desc.orEmpty(),
                    imageUrl = it.imageUrl.orEmpty()
                )
            }
    }

    private fun String?.dateFormat(): String {
        if (this == null) return ""
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            other = Instant
                .parse(this)
                .toLocalDateTime(TimeZone.currentSystemDefault())
                .date
        ).let {
            abs(it)
        }
        return when {
            days > 1 -> "$days days ago"
            days == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}