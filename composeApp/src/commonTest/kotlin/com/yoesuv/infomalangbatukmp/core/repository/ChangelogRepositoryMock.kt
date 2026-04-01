package com.yoesuv.infomalangbatukmp.core.repository

class ChangelogRepositoryMock(
    private val delegate: ChangelogRepository = ChangelogRepositoryImpl()
) : ChangelogRepository {
    
    var throwException = false
    var exceptionMessage = "Test error"

    override fun getChangelogResources() = if (throwException) {
        throw IllegalStateException(exceptionMessage)
    } else {
        delegate.getChangelogResources()
    }
}