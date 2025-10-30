package com.yoesuv.infomalangbatukmp.core.models

import kotlinx.serialization.Serializable

@Serializable
data class PinModel(
    val name: String?,
    val lokasi: Int?,
    val latitude: Double?,
    val longitude: Double?
)
