package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PinModel
import com.yoesuv.infomalangbatukmp.util.loadResource
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class PinsApiServiceMock : PinsApiService {
    
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    
    override suspend fun getPins(): List<PinModel> {
        val jsonString = loadResource("mock_pins.json")
        return json.decodeFromString(ListSerializer(PinModel.serializer()), jsonString)
    }
}