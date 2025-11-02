package com.yoesuv.infomalangbatukmp.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.quicksand_bold
import infomalangbatukmp.composeapp.generated.resources.quicksand_light
import infomalangbatukmp.composeapp.generated.resources.quicksand_medium
import infomalangbatukmp.composeapp.generated.resources.quicksand_regular
import infomalangbatukmp.composeapp.generated.resources.quicksand_semi_bold
import org.jetbrains.compose.resources.Font

@Composable
fun quicksandFontFamily() = FontFamily(
    Font(Res.font.quicksand_light, weight = FontWeight.Light),
    Font(Res.font.quicksand_regular, weight = FontWeight.Normal),
    Font(Res.font.quicksand_medium, weight = FontWeight.Medium),
    Font(Res.font.quicksand_semi_bold, weight = FontWeight.SemiBold),
    Font(Res.font.quicksand_bold, weight = FontWeight.Bold)
)

@Composable
fun quicksandTypography() = Typography().run {
    val fontFamily = quicksandFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}