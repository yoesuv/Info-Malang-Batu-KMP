package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoesuv.infomalangbatukmp.core.models.ChangeLogModel
import com.yoesuv.infomalangbatukmp.core.theme.AppColors
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.about_libraries
import org.jetbrains.compose.resources.stringResource

@Composable
fun TabLibraries() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(Res.string.about_libraries))
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
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = changelog.version ?: "",
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 14.sp, // Replace with your default_other_text_size
            fontWeight = FontWeight.Bold
        )

        Text(
            text = changelog.description ?: "",
            fontSize = 14.sp // Replace with your default_other_text_size
        )

        if (!(changelog.isLast ?: false)) {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                thickness = 1.dp,
            )
        }
    }
}
