package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.ChangelogTestData
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ItemChangeLogTest {

    private val testChangeLog = ChangelogTestData.createChangeLog()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysVersion() = runComposeUiTest {
        setContent {
            ItemChangeLog(changelog = testChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_VERSION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysDescription() = runComposeUiTest {
        setContent {
            ItemChangeLog(changelog = testChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_DESCRIPTION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullVersion() = runComposeUiTest {
        val nullVersionChangeLog = ChangelogTestData.createChangeLog(version = null)

        setContent {
            ItemChangeLog(changelog = nullVersionChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_DESCRIPTION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullDescription() = runComposeUiTest {
        val nullDescChangeLog = ChangelogTestData.createChangeLog(description = null)

        setContent {
            ItemChangeLog(changelog = nullDescChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_VERSION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun rendersWhenIsLastFalse() = runComposeUiTest {
        val notLastChangeLog = ChangelogTestData.createChangeLog(isLast = false)

        setContent {
            ItemChangeLog(changelog = notLastChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_VERSION).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun rendersWhenIsLastTrue() = runComposeUiTest {
        val lastChangeLog = ChangelogTestData.createChangeLog(isLast = true)

        setContent {
            ItemChangeLog(changelog = lastChangeLog)
        }

        onNodeWithText(ChangelogTestData.CHANGELOG_VERSION).assertIsDisplayed()
    }
}