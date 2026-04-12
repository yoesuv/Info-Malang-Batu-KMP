package com.yoesuv.infomalangbatukmp.testdata

import com.yoesuv.infomalangbatukmp.core.models.ChangeLogModel

object ChangelogTestData {
    const val CHANGELOG_VERSION = "1.0.2"
    const val CHANGELOG_DESCRIPTION = "add dependency injection, kover code coverage, add mock test"

    fun createChangeLog(
        version: String? = CHANGELOG_VERSION,
        description: String? = CHANGELOG_DESCRIPTION,
        isLast: Boolean? = false
    ) = ChangeLogModel(
        version = version,
        description = description,
        isLast = isLast
    )
}