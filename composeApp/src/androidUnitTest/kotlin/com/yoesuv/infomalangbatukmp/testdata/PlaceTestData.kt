package com.yoesuv.infomalangbatukmp.testdata

import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

object PlaceTestData {
    const val PLACE_NAME = "Alun Alun Malang"
    const val PLACE_LOCATION = "Kota Malang"
    const val PLACE_DESCRIPTION = "Deskripsi tempat wisata"
    const val PLACE_THUMBNAIL = "https://example.com/thumb.jpg"
    const val PLACE_IMAGE = "https://example.com/image.jpg"

    fun createPlace(
        nama: String? = PLACE_NAME,
        lokasi: String? = PLACE_LOCATION,
        deskripsi: String? = PLACE_DESCRIPTION,
        thumbnail: String? = PLACE_THUMBNAIL,
        gambar: String? = PLACE_IMAGE
    ) = PlaceModel(
        nama = nama,
        lokasi = lokasi,
        deskripsi = deskripsi,
        thumbnail = thumbnail,
        gambar = gambar
    )
}
