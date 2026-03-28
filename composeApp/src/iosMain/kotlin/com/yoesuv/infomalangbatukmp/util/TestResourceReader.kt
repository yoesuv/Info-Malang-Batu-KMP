package com.yoesuv.infomalangbatukmp.util

import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.stringWithContentsOfFile
import platform.Foundation.NSUTF8StringEncoding

actual fun loadResource(name: String): String {
    val resourceName = name.removeSuffix(".json")
    val path = NSBundle.mainBundle.pathForResource(resourceName, "json")
        ?: throw IllegalArgumentException("Resource not found: $name")
    return NSString.stringWithContentsOfFile(path, NSUTF8StringEncoding, null).toString()
}