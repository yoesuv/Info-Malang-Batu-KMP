package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

interface PlaceRepository {
    suspend fun getPlaces(): List<PlaceModel>
}