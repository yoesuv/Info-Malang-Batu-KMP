package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.LibraryModel

class LibrariesViewModel : ViewModel() {
    var libraries by mutableStateOf<List<LibraryModel>>(emptyList())
        private set

    fun updateLibraries(data: List<LibraryModel>) {
        libraries = data
    }
}
