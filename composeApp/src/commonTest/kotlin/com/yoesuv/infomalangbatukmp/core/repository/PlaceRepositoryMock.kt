package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceMock

class PlaceRepositoryMock(
    private val delegate: PlaceRepository = PlaceRepositoryImpl(PlaceApiServiceMock())
) : PlaceRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override suspend fun getPlaces() = if (throwException) {
        throw RuntimeException(exceptionMessage)
    } else {
        delegate.getPlaces()
    }
}