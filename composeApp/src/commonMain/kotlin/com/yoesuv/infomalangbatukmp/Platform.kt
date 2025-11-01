package com.yoesuv.infomalangbatukmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getAppVersion(): String