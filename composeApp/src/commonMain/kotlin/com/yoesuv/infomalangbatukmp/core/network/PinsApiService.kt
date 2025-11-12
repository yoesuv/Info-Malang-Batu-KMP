package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PinModel

interface PinsApiService {
    suspend fun getPins(): List<PinModel>
}
