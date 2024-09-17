package com.petros.efthymiou.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petros.efthymiou.dailypulse.android.screens.AboutScreen
import com.petros.efthymiou.dailypulse.android.screens.ArticleScreen
import com.petros.efthymiou.dailypulse.android.screens.Screens
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()
    Scaffold {
        NavHost(
            navController = navController,
            startDestination = Screens.ARTICLES.destination,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable(Screens.ARTICLES.destination) {
                ArticleScreen(articlesViewModel) {
                    navController.navigate(Screens.ABOUT_DEVICE.destination)
                }
            }
            composable(Screens.ABOUT_DEVICE.destination) {
                AboutScreen {
                    navController.popBackStack()
                }
            }
        }
    }
}