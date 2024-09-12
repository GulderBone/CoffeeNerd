package com.gulderbone.core.presentation.designsystem.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import com.gulderbone.core.presentation.designsystem.CoffeeNerdTheme


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
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.primary,
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

@ThemePreviews
@Composable
private fun GradientBackgroundPreview() {
    CoffeeNerdTheme {
        GradientBackground(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }
}

@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
annotation class ThemePreviews

@Preview(name = "Dark Mode", showBackground = true, uiMode = UI_MODE_NIGHT_YES, heightDp = 640, widthDp = 360)
@Preview(name = "Light Mode", showBackground = true, uiMode = UI_MODE_NIGHT_NO, heightDp = 640, widthDp = 360)
annotation class ScreenThemePreviews