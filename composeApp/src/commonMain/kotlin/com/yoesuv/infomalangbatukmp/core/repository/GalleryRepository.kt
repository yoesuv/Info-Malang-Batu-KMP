package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

interface GalleryRepository {
    suspend fun getGallery(): List<GalleryModel>
}