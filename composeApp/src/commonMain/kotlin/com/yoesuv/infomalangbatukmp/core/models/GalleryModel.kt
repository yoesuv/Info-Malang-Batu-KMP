package com.yoesuv.infomalangbatukmp.core.models

import kotlinx.serialization.Serializable

@Serializable
data class GalleryModel(
    val caption: String?,
    val thumbnail: String?,
    val image: String?
)
