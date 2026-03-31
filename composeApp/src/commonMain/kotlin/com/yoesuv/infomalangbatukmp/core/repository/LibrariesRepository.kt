package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.core.models.LibraryModel

interface LibrariesRepository {
    fun getLibraries(): List<LibraryModel>
}