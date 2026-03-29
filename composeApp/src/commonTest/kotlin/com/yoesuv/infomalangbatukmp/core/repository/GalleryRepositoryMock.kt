package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.GalleryApiServiceMock
import kotlinx.io.IOException

class GalleryRepositoryMock(
    private val delegate: GalleryRepository = GalleryRepositoryImpl(GalleryApiServiceMock())
) : GalleryRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override suspend fun getGallery() = if (throwException) {
        throw IOException(exceptionMessage)
    } else {
        delegate.getGallery()
    }
}