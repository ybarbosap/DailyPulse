package com.petros.efthymiou.dailypulse.android.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, actions: @Composable RowScope.() -> Unit = {}, navigationAction: @Composable () -> Unit = {}) {
    TopAppBar(
        title = { Text(text = title) },
        actions = actions,
        navigationIcon = navigationAction
    )
}