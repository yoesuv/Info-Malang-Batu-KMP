package com.yoesuv.infomalangbatukmp.core.models

import org.jetbrains.compose.resources.StringResource

data class LibraryModel(
    val name: StringResource?,
    val url: StringResource?,
    val license: StringResource?,
    val isLast: Boolean?
)