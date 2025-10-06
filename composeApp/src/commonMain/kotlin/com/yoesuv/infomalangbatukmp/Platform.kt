package com.yoesuv.infomalangbatukmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform