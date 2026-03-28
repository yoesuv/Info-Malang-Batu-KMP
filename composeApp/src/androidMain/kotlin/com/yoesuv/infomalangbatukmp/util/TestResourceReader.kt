package com.yoesuv.infomalangbatukmp.util

actual fun loadResource(name: String): String {
    val stream = object {}.javaClass.classLoader?.getResourceAsStream(name)
        ?: TestResourceReader::class.java.classLoader?.getResourceAsStream(name)
        ?: throw IllegalArgumentException("Resource not found: $name")
    return stream.bufferedReader().readText()
}

private class TestResourceReader