package com.capstone.techwastemark01.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Sakura80,
    onPrimary = Sakura20,
    primaryContainer = Sakura30,
    onPrimaryContainer = Sakura90,
    inversePrimary = Sakura40,

    secondary = DarkSakura80,
    onSecondary = DarkSakura20,
    secondaryContainer = DarkSakura30,
    onSecondaryContainer = DarkSakura90,

    tertiary = Ashen80,
    onTertiary = Ashen20,
    tertiaryContainer = Ashen36,
    onTertiaryContainer = Ashen90,

    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,

    background = Grey10,
    onBackground = Grey90,
    surface = SakuraGrey30,
    onSurface = SakuraGrey80,
    inverseSurface = Grey90,
    inverseOnSurface = Grey10,
    surfaceVariant = SakuraGrey30,
    onSurfaceVariant = SakuraGrey80,
    outline = SakuraGrey80

)

private val LightColorScheme = lightColorScheme(
    primary = Sakura68,
    onPrimary = Color.White,
    primaryContainer = Sakura90,
    onPrimaryContainer = Sakura10,
    inversePrimary = Sakura80,

    secondary = DarkSakura40,
    onSecondary = Color.White,
    secondaryContainer = DarkSakura90,
    onSecondaryContainer = DarkSakura10,

    tertiary = Ashen36,
    onTertiary = Color.White,
    tertiaryContainer = Ashen90,
    onTertiaryContainer = Ashen20,

    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,

    background = Grey99,
    onBackground = Grey10,
    surface = SakuraGrey90,
    onSurface = SakuraGrey30,
    inverseSurface = Grey20,
    inverseOnSurface = Grey95,
    surfaceVariant = SakuraGrey98,
    onSurfaceVariant = Grey50,
    outline = SakuraGrey50

)

@Composable
fun TechWasteMark01Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}