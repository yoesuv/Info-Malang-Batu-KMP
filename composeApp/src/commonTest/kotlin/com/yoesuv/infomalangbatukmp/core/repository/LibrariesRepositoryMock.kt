package com.yoesuv.infomalangbatukmp.core.repository

class LibrariesRepositoryMock(
    private val delegate: LibrariesRepository = LibrariesRepositoryImpl()
) : LibrariesRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override fun getLibraries() = if (throwException) {
        throw RuntimeException(exceptionMessage)
    } else {
        delegate.getLibraries()
    }
}