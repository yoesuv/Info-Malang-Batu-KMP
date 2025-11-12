package com.yoesuv.infomalangbatukmp.core.network

import com.yoesuv.infomalangbatukmp.core.models.PinModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * Service for fetching pins data from the API
 */
class PinsApiServiceImpl: PinsApiService {

    /**
     * Fetches the list of pins from the API
     * @return List of PinModel objects
     */
    override suspend fun getPins(): List<PinModel> {
        return HttpClientProvider.httpClient.get(ApiConstants.PINS_ENDPOINT) {
            contentType(ContentType.Application.Json)
        }.body()
    }
}
