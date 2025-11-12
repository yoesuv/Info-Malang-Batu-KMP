package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

interface PlaceApiService {
    suspend fun getPlaces(): List<PlaceModel>
}