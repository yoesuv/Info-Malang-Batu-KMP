package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_license
import infomalangbatukmp.composeapp.generated.resources.compose_multiplatform_url
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
            )
        )
    }
}
