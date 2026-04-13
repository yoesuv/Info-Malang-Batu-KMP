package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.MainActivityHolder
import kotlin.test.BeforeTest
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class TabInformationTest {

    @BeforeTest
    fun setup() {
        val application = ApplicationProvider.getApplicationContext<Application>()
        MainActivityHolder.initialize(application)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysAppName() = runComposeUiTest {
        setContent {
            TabInformation()
        }

        onNodeWithText("Info Malang Batu KMP").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysAboutAppInformation() = runComposeUiTest {
        setContent {
            TabInformation()
        }

        onNodeWithText("Compose Multiplatform Version").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysVersion() = runComposeUiTest {
        setContent {
            TabInformation()
        }

        // Use matcher to find text that starts with "Version " (with space)
        // This distinguishes from "Compose Multiplatform Version"
        onNode(hasText("Version ", substring = true)).assertIsDisplayed()
    }
}
