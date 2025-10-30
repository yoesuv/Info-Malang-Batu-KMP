package com.yoesuv.infomalangbatukmp.core.models

import kotlinx.serialization.Serializable

@Serializable
data class PlaceModel(
    val nama: String?,
    val lokasi: String?,
    val deskripsi: String?,
    val thumbnail: String?,
    val gambar: String?
)
