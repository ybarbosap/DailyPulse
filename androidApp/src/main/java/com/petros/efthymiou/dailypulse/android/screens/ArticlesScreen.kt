package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.petros.efthymiou.dailypulse.android.layout.AppBar
import com.petros.efthymiou.dailypulse.android.layout.ErrorMessage
import com.petros.efthymiou.dailypulse.android.layout.Loader
import com.petros.efthymiou.dailypulse.articles.Article
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel

@Composable
fun ArticleScreen(viewModel: ArticlesViewModel) {
    val articleState = viewModel.articlesState.collectAsState()
    Column {
        AppBar(title = "Articles")
        when {
            articleState.value.isLoading -> {
                Loader()
            }

            !(articleState.value.error.isNullOrEmpty()) -> {
                ErrorMessage(articleState.value.error!!)
            }
        }
        ArticlesListView(articles = articleState.value.articles)
    }
}

@Composable
private fun ArticlesListView(articles: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articles.size, key = { articles[it].title }) { index ->
            ArticleItemView(articles[index])
        }
    }
}

@Composable
private fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}
