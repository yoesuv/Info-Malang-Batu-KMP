package com.yoesuv.infomalangbatukmp.feature.about

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import infomalangbatukmp.composeapp.generated.resources.Res
import infomalangbatukmp.composeapp.generated.resources.thanks
import org.jetbrains.compose.resources.stringResource

@Composable
fun TabThanks() {
    Box(
        modifier = Modifier.fillMaxSize().padding(all = 16.dp),
    ) {
        Text(
            text = stringResource(Res.string.thanks),
            fontSize = 14.sp,
            lineHeight = 1.1.em,
            fontWeight = FontWeight.Medium,
        )
    }
}
