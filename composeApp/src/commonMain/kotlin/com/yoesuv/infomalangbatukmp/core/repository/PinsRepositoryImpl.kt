package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.PinModel
import com.yoesuv.infomalangbatukmp.core.network.PinsApiService

class PinsRepositoryImpl(
    private val pinsApiService: PinsApiService
) : PinsRepository {
    override suspend fun getPins(): List<PinModel> {
        return pinsApiService.getPins()
    }
}