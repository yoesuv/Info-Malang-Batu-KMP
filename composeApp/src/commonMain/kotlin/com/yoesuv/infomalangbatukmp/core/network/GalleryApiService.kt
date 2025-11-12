package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

interface GalleryApiService {
    suspend fun getGallery(): List<GalleryModel>
}
