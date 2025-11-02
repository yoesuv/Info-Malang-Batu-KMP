package com.yoesuv.infomalangbatukmp.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = quicksandTypography(),
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = AppColors.Primary,
            primaryContainer = AppColors.Primary,
            onPrimaryContainer = Color.White,
            secondaryContainer = AppColors.Primary.copy(alpha = 0.3f),
            onSecondaryContainer = AppColors.Primary
        ),
        content = content
    )
}
