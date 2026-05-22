package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme =
  lightColorScheme(
    primary = DarkBtnBg,
    onPrimary = Color.White,
    background = WarmBg,
    onBackground = DarkText,
    surface = WarmBg,
    onSurface = DarkText,
    secondary = EarthyAccent,
    tertiary = CardBg1
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false, // Disable dynamic colors to keep Natural Tones
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) {
    // For Natural Tones we use same scheme since it is warm natural light shades,
    // or fallback to it gracefully.
    LightColorScheme
  } else {
    LightColorScheme
  }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
