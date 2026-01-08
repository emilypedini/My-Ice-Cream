package com.example.myicecream.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



private val DarkColors = darkColorScheme(
    background = Black,
    surface = Black,
    onBackground = White,
    onSurface = White,
    primary = White
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF5C4638),
    onPrimary = Color(0xFFFDFDFD),
    background = Color(0xFFFDFDFD),
    surface = Color(0xFFFDFDFD),
    onSurface = Color(0xFF5C4638)
)

@Composable
fun MyIceCreamTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}