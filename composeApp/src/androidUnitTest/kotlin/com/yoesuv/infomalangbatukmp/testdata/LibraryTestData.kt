package com.yoesuv.infomalangbatukmp.testdata

import com.yoesuv.infomalangbatukmp.core.models.LibraryModel
import com.yoesuv.infomalangbatukmp.core.repository.LibrariesRepositoryImpl

object LibraryTestData {
    const val LIBRARY_NAME = "Compose Multiplatform"
    const val LIBRARY_URL = "https://www.jetbrains.com/compose-multiplatform/"
    const val LIBRARY_LICENSE_TEXT = "Copyright 2020-2021 JetBrains s.r.o. and and respective authors and developers."

    private val repository = LibrariesRepositoryImpl()

    fun createLibrary(
        nameIsNull: Boolean = false,
        urlIsNull: Boolean = false,
        licenseIsNull: Boolean = false,
        isLast: Boolean? = false
    ): LibraryModel {
        val real = repository.getLibraries().first()
        return LibraryModel(
            name = if (nameIsNull) null else real.name,
            url = if (urlIsNull) null else real.url,
            license = if (licenseIsNull) null else real.license,
            isLast = isLast
        )
    }

    fun createLibraries(): List<LibraryModel> = repository.getLibraries()
}