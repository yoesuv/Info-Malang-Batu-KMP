package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.ChangeLogModel

class ChangelogViewModel : ViewModel() {
    var changelogs by mutableStateOf<List<ChangeLogModel>>(emptyList())
        private set

    fun updateChangelogs(data: List<ChangeLogModel>) {
        changelogs = data
    }
}
