package com.yoesuv.infomalangbatukmp

import android.app.Application
import com.yoesuv.infomalangbatukmp.core.di.KoinInitializer

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer.init()
    }
}