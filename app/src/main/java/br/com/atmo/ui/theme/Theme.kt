package br.com.atmo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

val AtmoDarkColorScheme = darkColorScheme(
    primary = AtmoCyan,
    onPrimary = AtmoOnCyan,
    primaryContainer = AtmoSurfaceVariant,
    onPrimaryContainer = AtmoCyan,

    secondary = AtmoTextSecondary,
    onSecondary = AtmoBackground,
    secondaryContainer = AtmoSurfaceVariant,
    onSecondaryContainer = AtmoTextPrimary,

    tertiary = AtmoPositive,
    onTertiary = AtmoOnPositive,
    tertiaryContainer = AtmoOnPositive,
    onTertiaryContainer = AtmoPositive,

    background = AtmoBackground,
    onBackground = AtmoTextPrimary,

    surface = AtmoSurface,
    onSurface = AtmoTextPrimary,
    surfaceVariant = AtmoSurfaceVariant,
    onSurfaceVariant = AtmoTextSecondary,

    error = AtmoError,
    onError = AtmoOnError,
    errorContainer = AtmoError,
    onErrorContainer = AtmoOnError,

    outline = AtmoBorder,
    outlineVariant = AtmoSurfaceVariant,
    scrim = AtmoBackground,
)

@Composable
fun AtmoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AtmoDarkColorScheme,
        content = content,
    )}