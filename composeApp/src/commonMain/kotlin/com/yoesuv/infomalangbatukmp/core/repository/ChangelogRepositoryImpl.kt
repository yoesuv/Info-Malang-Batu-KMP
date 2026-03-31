package com.yoesuv.infomalangbatukmp.core.repository

import com.yoesuv.infomalangbatukmp.feature.about.ChangeLogResource
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.changelog_desc_1_0_0
import infomalangbatukmp.composeapp.generated.resources.changelog_desc_1_0_1
import infomalangbatukmp.composeapp.generated.resources.changelog_version_1_0_0
import infomalangbatukmp.composeapp.generated.resources.changelog_version_1_0_1

class ChangelogRepositoryImpl : ChangelogRepository {
    override fun getChangelogResources(): List<ChangeLogResource> {
        return listOf(
            ChangeLogResource(
                versionRes = Res.string.changelog_version_1_0_1,
                descriptionRes = Res.string.changelog_desc_1_0_1
            ),
            ChangeLogResource(
                versionRes = Res.string.changelog_version_1_0_0,
                descriptionRes = Res.string.changelog_desc_1_0_0
            )
        )
    }
}