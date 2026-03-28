package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiService

class PlaceRepositoryImpl(
    private val placeApiService: PlaceApiService
) : PlaceRepository {
    override suspend fun getPlaces(): List<PlaceModel> {
        return placeApiService.getPlaces()
    }
}