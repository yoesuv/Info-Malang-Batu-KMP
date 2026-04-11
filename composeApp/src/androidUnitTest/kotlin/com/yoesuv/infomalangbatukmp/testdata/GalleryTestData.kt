package com.yoesuv.infomalangbatukmp.testdata

import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

object GalleryTestData {
    const val GALLERY_CAPTION = "Gallery Caption"
    const val GALLERY_THUMBNAIL = "https://example.com/thumb.jpg"
    const val GALLERY_IMAGE = "https://example.com/image.jpg"

    fun createGallery(
        caption: String? = GALLERY_CAPTION,
        thumbnail: String? = GALLERY_THUMBNAIL,
        image: String? = GALLERY_IMAGE
    ) = GalleryModel(
        caption = caption,
        thumbnail = thumbnail,
        image = image
    )
}
