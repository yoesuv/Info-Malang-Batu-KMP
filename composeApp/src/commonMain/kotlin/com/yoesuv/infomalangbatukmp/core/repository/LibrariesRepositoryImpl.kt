package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.coil
import infomalangbatukmp.composeapp.generated.resources.coil_license
import infomalangbatukmp.composeapp.generated.resources.coil_url
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_license
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_url
import infomalangbatukmp.composeapp.generated.resources.kmp_maps
import infomalangbatukmp.composeapp.generated.resources.kmp_maps_license
import infomalangbatukmp.composeapp.generated.resources.kmp_maps_url
import infomalangbatukmp.composeapp.generated.resources.koin
import infomalangbatukmp.composeapp.generated.resources.koin_license
import infomalangbatukmp.composeapp.generated.resources.koin_url
import infomalangbatukmp.composeapp.generated.resources.kotlinx_kover
import infomalangbatukmp.composeapp.generated.resources.kotlinx_kover_license
import infomalangbatukmp.composeapp.generated.resources.kotlinx_kover_url
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization_license
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization_url
import infomalangbatukmp.composeapp.generated.resources.ksoup
import infomalangbatukmp.composeapp.generated.resources.ksoup_license
import infomalangbatukmp.composeapp.generated.resources.ksoup_url
import infomalangbatukmp.composeapp.generated.resources.ktor
import infomalangbatukmp.composeapp.generated.resources.ktor_license
import infomalangbatukmp.composeapp.generated.resources.ktor_url

class LibrariesRepositoryImpl : LibrariesRepository {
    override fun getLibraries(): List<LibraryModel> {
        return listOf(
            LibraryModel(
                name = Res.string.compose_multiplatform,
                url = Res.string.compose_multiplatform_url,
                license = Res.string.compose_multiplatform_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.coil,
                url = Res.string.coil_url,
                license = Res.string.coil_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.kmp_maps,
                url = Res.string.kmp_maps_url,
                license = Res.string.kmp_maps_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.koin,
                url = Res.string.koin_url,
                license = Res.string.koin_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.kotlinx_kover,
                url = Res.string.kotlinx_kover_url,
                license = Res.string.kotlinx_kover_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.kotlinx_serialization,
                url = Res.string.kotlinx_serialization_url,
                license = Res.string.kotlinx_serialization_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.ksoup,
                url = Res.string.ksoup_url,
                license = Res.string.ksoup_license,
                isLast = false
            ),
            LibraryModel(
                name = Res.string.ktor,
                url = Res.string.ktor_url,
                license = Res.string.ktor_license,
                isLast = true
            )
        )
    }
}