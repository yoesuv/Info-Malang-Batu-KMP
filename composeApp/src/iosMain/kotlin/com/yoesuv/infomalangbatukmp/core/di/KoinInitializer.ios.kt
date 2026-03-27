package com.yoesuv.infomalangbatukmp.core.di

import org.koin.core.context.startKoin

actual object KoinInitializer {
    actual fun init() {
        startKoin {
            modules(appModule)
        }
    }
}