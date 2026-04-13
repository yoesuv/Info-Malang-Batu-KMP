package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class TabThanksTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysThanksText() = runComposeUiTest {
        setContent {
            TabThanks()
        }

        onNodeWithText("terima kasih", substring = true).assertIsDisplayed()
    }
}
