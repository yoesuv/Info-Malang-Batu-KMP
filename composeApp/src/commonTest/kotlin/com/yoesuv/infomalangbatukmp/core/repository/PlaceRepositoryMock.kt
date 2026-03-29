package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceMock
import kotlinx.io.IOException

class PlaceRepositoryMock(
    private val delegate: PlaceRepository = PlaceRepositoryImpl(PlaceApiServiceMock())
) : PlaceRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override suspend fun getPlaces() = if (throwException) {
        throw IOException(exceptionMessage)
    } else {
        delegate.getPlaces()
    }
}