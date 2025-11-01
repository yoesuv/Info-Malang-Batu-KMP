package com.yoesuv.infomalangbatukmp

import android.os.Build
import android.content.Context

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun getAppVersion(): String {
    return try {
        val context = MainActivityHolder.applicationContext
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName ?: "1.0.0"
    } catch (e: Exception) {
        "1.0.0"
    }
}

object MainActivityHolder {
    lateinit var applicationContext: Context
        private set
    
    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }
}