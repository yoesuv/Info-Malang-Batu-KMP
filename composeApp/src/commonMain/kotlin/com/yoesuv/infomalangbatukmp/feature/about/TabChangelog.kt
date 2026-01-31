package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoesuv.infomalangbatukmp.core.models.ChangeLogModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun TabChangelog() {
    val viewModel = remember { ChangelogViewModel() }
    val changelogItems = viewModel.changelogResources.mapIndexed { index, item ->
        ChangeLogModel(
            version = stringResource(item.versionRes),
            description = stringResource(item.descriptionRes),
            isLast = index == viewModel.changelogResources.lastIndex
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(changelogItems) { item ->
            ItemChangeLog(changelog = item)
        }
    }
}

@Composable
fun ItemChangeLog(
    changelog: ChangeLogModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = changelog.version ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = changelog.description ?: "",
            fontSize = 14.sp
        )

        if (!(changelog.isLast ?: false)) {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                thickness = 1.dp,
            )
        }
    }
}
