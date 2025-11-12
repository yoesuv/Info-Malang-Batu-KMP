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

    companion object {
        private const val BASE_URL = "https://info-malang-batu.firebaseapp.com"
        private const val PLACES_ENDPOINT = "$BASE_URL/List_place_malang_batu.json"
    }

    /**
     * Fetches the list of places from the API
     * @return List of PlaceModel objects
     */
    override suspend fun getPlaces(): List<PlaceModel> {
        return HttpClientProvider.httpClient.get(PLACES_ENDPOINT) {
            contentType(ContentType.Application.Json)
        }.body()
    }
}