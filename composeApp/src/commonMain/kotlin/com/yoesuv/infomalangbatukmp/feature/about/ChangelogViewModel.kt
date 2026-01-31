package com.yoesuv.infomalangbatukmp.feature.about

import androidx.lifecycle.ViewModel
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.changelog_desc_1_0_0
import infomalangbatukmp.composeapp.generated.resources.changelog_desc_1_0_1
import infomalangbatukmp.composeapp.generated.resources.changelog_version_1_0_0
import infomalangbatukmp.composeapp.generated.resources.changelog_version_1_0_1
import org.jetbrains.compose.resources.StringResource

data class ChangeLogResource(
    val versionRes: StringResource,
    val descriptionRes: StringResource
)

class ChangelogViewModel : ViewModel() {
    val changelogResources = listOf(
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
