package com.yoesuv.infomalangbatukmp.feature.gallery

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.GalleryModel

class GalleryViewModel : ViewModel() {
    var galleries by mutableStateOf<List<GalleryModel>>(emptyList())
        private set

    init {
        loadDummyGallery()
    }

    fun updateGalleries(data: List<GalleryModel>) {
        galleries = data
    }

    fun loadDummyGallery() {
        updateGalleries(
            listOf(
                GalleryModel(
                    caption = "Alun Alun Malang",
                    thumbnail = "https://lh3.googleusercontent.com/-7To0y-nnYak/VqQYjBWAwoI/AAAAAAAACf8/r_sAJ-dgsL8/s250-Ic42/thumbnail_alun_alun_malang.jpg",
                    image = "https://lh3.googleusercontent.com/-rTHiiW3vPMk/VqQXrbG5u6I/AAAAAAAACfs/buFhkMyTN98/s600-Ic42/alun_alun_malang.jpg"
                ),
                GalleryModel(
                    caption = "Alun Alun Batu",
                    thumbnail = "https://lh3.googleusercontent.com/-R0ipuAxdPus/VpgqL1YRyRI/AAAAAAAACdI/XWkGUZpTegE/s250-Ic42/thumbnail_alun_alun_batu.jpg",
                    image = "https://lh3.googleusercontent.com/-bFfINcFXjFM/VpgkzblyBhI/AAAAAAAACbg/r6z0tBnCBMY/s800-Ic42/alun_alun_batu.jpg"
                ),
                GalleryModel(
                    caption = "Taman Tugu",
                    thumbnail = "https://lh3.googleusercontent.com/-8WR-7K3f3xg/VqQYjZvb7-I/AAAAAAAACgA/Io4_UnWYIdo/s250-Ic42/thumbnail_alun_alun_tugu_malang.jpg",
                    image = "https://lh3.googleusercontent.com/-f2jvOWu4sBE/VqQXZQlUhuI/AAAAAAAACfk/6EEOBSwgIFE/s600-Ic42/alun_alun_tugu_malang.jpg"
                ),
                GalleryModel(
                    caption = "Gunung Bromo",
                    thumbnail = "https://lh3.googleusercontent.com/-3ZeMDlvAbTw/VqWeZyHYbdI/AAAAAAAAChk/P2WFYWhHtMc/s250-Ic42/thumbnail_gunung_bromo.jpg",
                    image = "https://lh3.googleusercontent.com/-hrZPvs0iuhw/VqWec-d81kI/AAAAAAAAChs/Bl1v4J2fvh4/s800-Ic42/gunung_bromo.jpg"
                ),
                GalleryModel(
                    caption = "Jatim Park 1",
                    thumbnail = "https://lh3.googleusercontent.com/-dXQZBPwxpyw/VpgqOJlOudI/AAAAAAAACdo/RjUPX5853kU/s250-Ic42/thumbnail_jatim_park_1.jpg",
                    image = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/bc4f8d86-6790-4e4a-950f-0ef74d0ad174/ddjf2sr-e19fa7cf-1675-4398-b061-c4706f188373.jpg"
                ),
                GalleryModel(
                    caption = "Museum Angkut",
                    thumbnail = "https://lh3.googleusercontent.com/-LKzy1YBNGPQ/VpgqP6PhYcI/AAAAAAAACeA/92J9FKCtsn4/s250-Ic42/thumbnail_museum_angkut.jpg",
                    image = "https://lh3.googleusercontent.com/-cCvFKGPQxx4/VpgkAiX4NxI/AAAAAAAACbA/qozmKMVyaGc/s800-Ic42/museum_angkut.jpg"
                ),
                GalleryModel(
                    caption = "Pantai Balekambang",
                    thumbnail = "https://lh3.googleusercontent.com/-o3a8cS0V5gA/VpgqKdkLpqI/AAAAAAAACc8/EETKTJFFPnM/s250-Ic42/thumbnail_pantai_balekambang.jpg",
                    image = "https://lh3.googleusercontent.com/-7uPTM3KbS78/Vpgk_NV3ppI/AAAAAAAACbw/7N9cOck9ZBw/s800-Ic42/pantai_balekambang.jpg"
                ),
                GalleryModel(
                    caption = "Selecta",
                    thumbnail = "https://lh3.googleusercontent.com/-pS5CHDKMj2k/VpgqWDAVGwI/AAAAAAAACho/7M3VDFPn1cw/s250-Ic42/thumbnail_selecta.jpg",
                    image = "https://lh3.googleusercontent.com/-LJE6TLke1lQ/Vpgk9ZvbNBI/AAAAAAAACbo/9X9evynG8DU/s800-Ic42/selecta.jpg"
                ),
                GalleryModel(
                    caption = "Kampung Warna Warni",
                    thumbnail = "https://lh3.googleusercontent.com/-Qc1Q-UlUQYs/VpgqYG8bRjI/AAAAAAAACiA/stVKMqDPL74/s250-Ic42/thumbnail_kampung_warna_warni.jpg",
                    image = "https://lh3.googleusercontent.com/-xUuFOHQbrj8/Vpgk_BA8VxI/AAAAAAAACb0/n8YlZQ2lV8k/s800-Ic42/kampung_warna_warni.jpg"
                )
            )
        )
    }
}
