package com.yoesuv.infomalangbatukmp.core.network

/**
 * Centralized constants for API endpoints
 */
object ApiConstants {
    private const val BASE_URL = "https://info-malang-batu.firebaseapp.com"
    
    const val PLACES_ENDPOINT = "$BASE_URL/List_place_malang_batu.json"
    const val GALLERY_ENDPOINT = "$BASE_URL/Gallery_Malang_Batu.json"
    const val PINS_ENDPOINT = "$BASE_URL/Maps_Malang_Batu.json"
}
