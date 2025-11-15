package com.yoesuv.infomalangbatukmp.core.route

import kotlinx.serialization.Serializable

sealed class AppRoute {
    @Serializable
    data object Splash : AppRoute()
    @Serializable
    data object Home : AppRoute()
    @Serializable
    data class DetailGallery(val image: String, val caption: String) : AppRoute()
}