package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import com.yoesuv.infomalangbatukmp.util.loadResource
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class GalleryApiServiceMock : GalleryApiService {
    
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    
    override suspend fun getGallery(): List<GalleryModel> {
        val jsonString = loadResource("mock_gallery.json")
        return json.decodeFromString(ListSerializer(GalleryModel.serializer()), jsonString)
    }
}