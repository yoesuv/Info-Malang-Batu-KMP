package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.PinModel

interface PinsRepository {
    suspend fun getPins(): List<PinModel>
}