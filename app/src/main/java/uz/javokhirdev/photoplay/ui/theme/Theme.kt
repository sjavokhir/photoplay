package uz.javokhirdev.photoplay.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import uz.javokhirdev.photoplay.coreui.*

private val DarkColorPalette = darkColors(
    primary = AppPrimary,
    primaryVariant = Color.Black,
    secondary = AppPrimary,
    background = DarkBackground,
    onBackground = Color.White,
    surface = DarkGray,
    onSurface = Color.White,
    onPrimary = DarkGray,
    onSecondary = DarkGray,
)

private val LightColorPalette = lightColors(
    primary = AppPrimary,
    primaryVariant = Color.Black,
    secondary = AppPrimary,
    background = LightBackground,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun CaloryTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}