package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.core.network.GalleryApiService

class GalleryRepositoryImpl(
    private val galleryApiService: GalleryApiService
) : GalleryRepository {
    override suspend fun getGallery(): List<GalleryModel> {
        return galleryApiService.getGallery()
    }
}