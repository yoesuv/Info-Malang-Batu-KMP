package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * Service for fetching gallery data from the API
 */
class GalleryApiServiceImpl: GalleryApiService {

    /**
     * Fetches the list of gallery items from the API
     * @return List of GalleryModel objects
     */
    override suspend fun getGallery(): List<GalleryModel> {
        return HttpClientProvider.httpClient.get(ApiConstants.GALLERY_ENDPOINT) {
            contentType(ContentType.Application.Json)
        }.body()
    }
}
