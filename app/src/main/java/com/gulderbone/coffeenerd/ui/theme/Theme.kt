package com.gulderbone.coffeenerd.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = CoffeeNerdBrown,
    background = CoffeeNerdBlack,
    surface = CoffeeNerdDarkGray,
    secondary = CoffeeNerdWhite,
    tertiary = CoffeeNerdWhite,
    primaryContainer = CoffeeNerdDarkerBrown,
    onPrimary = CoffeeNerdBlack,
    onBackground = CoffeeNerdWhite,
    onSurface = CoffeeNerdWhite,
    onSurfaceVariant = CoffeeNerdGray,
    error = CoffeeNerdDarkRed,
    errorContainer = CoffeeNerdDarkRed5
)

@Composable
fun CoffeeNerdTheme(
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}

