package com.yoesuv.infomalangbatukmp.feature.about

import android.app.Application
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yoesuv.infomalangbatukmp.testdata.LibraryTestData
import kotlin.test.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [33], application = Application::class)
class ItemLibraryTest {

    private val testLibrary = LibraryTestData.createLibrary()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysLibraryName() = runComposeUiTest {
        setContent {
            ItemLibrary(library = testLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysLibraryUrl() = runComposeUiTest {
        setContent {
            ItemLibrary(library = testLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_URL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun displaysLibraryLicense() = runComposeUiTest {
        setContent {
            ItemLibrary(library = testLibrary)
        }

        onNodeWithText("Copyright 2020-2021 JetBrains s.r.o.", substring = true).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullName() = runComposeUiTest {
        val nullNameLibrary = LibraryTestData.createLibrary(nameIsNull = true)

        setContent {
            ItemLibrary(library = nullNameLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_URL).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullUrl() = runComposeUiTest {
        val nullUrlLibrary = LibraryTestData.createLibrary(urlIsNull = true)

        setContent {
            ItemLibrary(library = nullUrlLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun handlesNullLicense() = runComposeUiTest {
        val nullLicenseLibrary = LibraryTestData.createLibrary(licenseIsNull = true)

        setContent {
            ItemLibrary(library = nullLicenseLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun rendersWhenIsLastFalse() = runComposeUiTest {
        val notLastLibrary = LibraryTestData.createLibrary(isLast = false)

        setContent {
            ItemLibrary(library = notLastLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun rendersWhenIsLastTrue() = runComposeUiTest {
        val lastLibrary = LibraryTestData.createLibrary(isLast = true)

        setContent {
            ItemLibrary(library = lastLibrary)
        }

        onNodeWithText(LibraryTestData.LIBRARY_NAME).assertIsDisplayed()
    }
}