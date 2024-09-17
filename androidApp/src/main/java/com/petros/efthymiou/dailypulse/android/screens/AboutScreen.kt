package com.petros.efthymiou.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.petros.efthymiou.dailypulse.Platform
import com.petros.efthymiou.dailypulse.android.layout.AppBar

@Composable
fun AboutScreen(onDismiss: () -> Unit) {
    Column {
        AppBar("About Device") {
            IconButton(onDismiss) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            }
        }
        ContentView()
    }
}

@Composable
private fun ContentView() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(makeItems()) { item ->
            RowView(item)
        }
    }
}

data class ContentViewItem(val title: String, val subtitle: String)

private fun makeItems(): List<ContentViewItem> {
    val platform = Platform()
    platform.logSystemInfo()
    return listOf(
        ContentViewItem("Operating System", platform.osName + " " + platform.osVersion),
        ContentViewItem("Device", platform.deviceModel),
        ContentViewItem("Density", platform.density.toString()),
    )
}

@Composable
fun RowView(item: ContentViewItem) {
    Column(modifier = Modifier.padding(8.dp)) {
        Column {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        Divider()
    }
}
