package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.feature.about.ChangeLogResource

interface ChangelogRepository {
    fun getChangelogResources(): List<ChangeLogResource>
}