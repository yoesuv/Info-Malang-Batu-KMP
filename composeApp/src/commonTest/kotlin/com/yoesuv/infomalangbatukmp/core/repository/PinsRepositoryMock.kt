package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.network.PinsApiServiceMock
import kotlinx.io.IOException

class PinsRepositoryMock(
    private val delegate: PinsRepository = PinsRepositoryImpl(PinsApiServiceMock())
) : PinsRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override suspend fun getPins() = if (throwException) {
        throw IOException(exceptionMessage)
    } else {
        delegate.getPins()
    }
}