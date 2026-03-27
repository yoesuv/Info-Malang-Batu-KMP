package com.yoesuv.infomalangbatukmp

import androidx.compose.ui.window.ComposeUIViewController
import com.yoesuv.infomalangbatukmp.core.di.KoinInitializer

fun MainViewController() = ComposeUIViewController { 
    KoinInitializer.init()
    App() 
}