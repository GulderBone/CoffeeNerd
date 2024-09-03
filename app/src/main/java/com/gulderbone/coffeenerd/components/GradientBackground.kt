package com.gulderbone.coffeenerd.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.gulderbone.coffeenerd.ui.theme.CoffeeNerdTheme

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    hasToolbar: Boolean = true,
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (hasToolbar) {
                        Modifier.systemBarsPadding()
                    } else {
                        Modifier
                    }
                )
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun GradientBackgroundPreview() {
    CoffeeNerdTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}