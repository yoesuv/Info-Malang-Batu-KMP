package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import infomalangbatukmp.composeapp.generated.resources.coil
import infomalangbatukmp.composeapp.generated.resources.coil_license
import infomalangbatukmp.composeapp.generated.resources.coil_url
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_license
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_url
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization_license
import infomalangbatukmp.composeapp.generated.resources.kotlinx_serialization_url
import infomalangbatukmp.composeapp.generated.resources.ksoup
import infomalangbatukmp.composeapp.generated.resources.ksoup_license
import infomalangbatukmp.composeapp.generated.resources.ksoup_url
import infomalangbatukmp.composeapp.generated.resources.ktor
import infomalangbatukmp.composeapp.generated.resources.ktor_license
import infomalangbatukmp.composeapp.generated.resources.ktor_url
import infomalangbatukmp.composeapp.generated.resources.Res.string as str

class LibrariesViewModel : ViewModel() {
    var libraries by mutableStateOf<List<LibraryModel>>(emptyList())
        private set

    fun updateLibraries(data: List<LibraryModel>) {
        libraries = data
    }

    fun loadLibraries() {
        updateLibraries(
            listOf(
                LibraryModel(
                    name = str.compose_multiplatform,
                    url = str.compose_multiplatform_url,
                    license = str.compose_multiplatform_license,
                    isLast = false
                ),
                LibraryModel(
                    name = str.coil,
                    url = str.coil_url,
                    license = str.coil_license,
                    isLast = false
                ),
                LibraryModel(
                    name = str.kotlinx_serialization,
                    url = str.kotlinx_serialization_url,
                    license = str.kotlinx_serialization_license,
                    isLast = false
                ),
                LibraryModel(
                    name = str.ksoup,
                    url = str.ksoup_url,
                    license = str.ksoup_license,
                    isLast = false
                ),
                LibraryModel(
                    name = str.ktor,
                    url = str.ktor_url,
                    license = str.ktor_license,
                    isLast = true
                ),
            )
        )
    }
}
