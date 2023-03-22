package com.example.nycshools.shared

import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Simple Reusable AppBarr
 * @tittle: app bar title
 */
@Composable
fun TopAppBarSample(
    title: String
) {
    Column {
        TopAppBar(
            elevation = 4.dp,
            title = {
                Text(title)
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowTopAppBar() {
    TopAppBar(title = { Text("any") })
}
