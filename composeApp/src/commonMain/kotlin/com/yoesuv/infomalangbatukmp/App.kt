package com.yoesuv.infomalangbatukmp

import androidx.compose.runtime.Composable
import com.yoesuv.infomalangbatukmp.core.theme.AppTheme
import com.yoesuv.infomalangbatukmp.core.route.AppRoute
import com.yoesuv.infomalangbatukmp.feature.home.HomeScreen
import com.yoesuv.infomalangbatukmp.feature.splash.SplashScreen
import com.yoesuv.infomalangbatukmp.feature.gallery.DetailGalleryScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AppRoute.Splash
        ) {
            composable<AppRoute.Splash> {
                SplashScreen(navController)
            }
            composable<AppRoute.Home> {
                HomeScreen(navController = navController)
            }
            composable<AppRoute.DetailGallery> { backStackEntry ->
                val detailRoute = backStackEntry.toRoute<AppRoute.DetailGallery>()
                DetailGalleryScreen(
                    image = detailRoute.image,
                    caption = detailRoute.caption,
                    onNavigateUp = { navController.navigateUp() }
                )
            }
        }
    }
}