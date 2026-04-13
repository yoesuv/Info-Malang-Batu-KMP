package com.yoesuv.infomalangbatukmp.testdata

import com.yoesuv.infomalangbatukmp.core.models.PinModel

object PinTestData {
    const val PIN_NAME = "Alun Alun Malang"
    const val PIN_LOCATION_ID = 1
    const val PIN_LATITUDE = -7.982914
    const val PIN_LONGITUDE = 112.630875

    fun createPin(
        name: String? = PIN_NAME,
        lokasi: Int? = PIN_LOCATION_ID,
        latitude: Double? = PIN_LATITUDE,
        longitude: Double? = PIN_LONGITUDE
    ) = PinModel(
        name = name,
        lokasi = lokasi,
        latitude = latitude,
        longitude = longitude
    )

    fun createPins() = listOf(
        createPin(),
        createPin(
            name = "Alun Alun Batu",
            lokasi = 2,
            latitude = -7.8671,
            longitude = 112.5239
        )
    )
}
