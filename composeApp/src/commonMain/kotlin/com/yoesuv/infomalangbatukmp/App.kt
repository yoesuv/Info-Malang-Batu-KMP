package com.yoesuv.infomalangbatukmp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yoesuv.infomalangbatukmp.core.route.AppRoute
import com.yoesuv.infomalangbatukmp.feature.home.HomeScreen
import com.yoesuv.infomalangbatukmp.feature.splash.SplashScreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.yoesuv.infomalangbatukmp.core.theme.AppColors
import com.yoesuv.infomalangbatukmp.core.theme.quicksandTypography

@Composable
fun App() {
    MaterialTheme(
        typography = quicksandTypography(),
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = AppColors.Primary,
            primaryContainer = AppColors.Primary,
            onPrimaryContainer = Color.White,
            secondaryContainer = AppColors.Primary.copy(alpha = 0.3f),
            onSecondaryContainer = AppColors.Primary
        )
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AppRoute.Splash
        ) {
            composable<AppRoute.Splash> {
                SplashScreen(navController)
            }
            composable<AppRoute.Home> {
                HomeScreen()
            }
        }
    }
}