package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import com.yoesuv.infomalangbatukmp.util.loadResource
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class PlaceApiServiceMock : PlaceApiService {
    
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    
    override suspend fun getPlaces(): List<PlaceModel> {
        val jsonString = loadResource("mock_places.json")
        return json.decodeFromString(ListSerializer(PlaceModel.serializer()), jsonString)
    }
}