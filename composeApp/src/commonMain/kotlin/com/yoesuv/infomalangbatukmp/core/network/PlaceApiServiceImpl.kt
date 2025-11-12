package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * Service for fetching place data from the API
 */
class PlaceApiServiceImpl: PlaceApiService {

    /**
     * Fetches the list of places from the API
     * @return List of PlaceModel objects
     */
    override suspend fun getPlaces(): List<PlaceModel> {
        return HttpClientProvider.httpClient.get(ApiConstants.PLACES_ENDPOINT) {
            contentType(ContentType.Application.Json)
        }.body()
    }
}