package com.yoesuv.infomalangbatukmp.feature.listplace

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.yoesuv.infomalangbatukmp.core.models.PlaceModel

class ListPlaceViewModel : ViewModel() {
    var places by mutableStateOf<List<PlaceModel>>(emptyList())
        private set

    init {
        loadDummyPlaces()
    }

    fun updatePlaces(data: List<PlaceModel>) {
        places = data
    }

    fun loadDummyPlaces() {
        updatePlaces(
            listOf(
                PlaceModel(
                    nama = "Alun Alun Malang",
                    lokasi = "Kota Malang",
                    deskripsi = "alun alun ini baru saja dipermak pada tahun 2015. yang sebelumnya terlihat semrawut sekarang menjadi lebih tertata.",
                    thumbnail = "https://lh3.googleusercontent.com/-7To0y-nnYak/VqQYjBWAwoI/AAAAAAAACf8/r_sAJ-dgsL8/s250-Ic42/thumbnail_alun_alun_malang.jpg",
                    gambar = "https://lh3.googleusercontent.com/-rTHiiW3vPMk/VqQXrbG5u6I/AAAAAAAACfs/buFhkMyTN98/s600-Ic42/alun_alun_malang.jpg"
                ),
                PlaceModel(
                    nama = "Alun alun Tugu",
                    lokasi = "Kota Malang",
                    deskripsi = "Di bagian tengah alun-alun ini terdapat sebuah tugu yang dikelilingi oleh kolam teratai. Alun-Alun Tugu/Bundar terletak di depan Balai Kota Malang.",
                    thumbnail = "https://lh3.googleusercontent.com/-8WR-7K3f3xg/VqQYjZvb7-I/AAAAAAAACgA/Io4_UnWYIdo/s250-Ic42/thumbnail_alun_alun_tugu_malang.jpg",
                    gambar = "https://lh3.googleusercontent.com/-f2jvOWu4sBE/VqQXZQlUhuI/AAAAAAAACfk/6EEOBSwgIFE/s600-Ic42/alun_alun_tugu_malang.jpg"
                ),
                PlaceModel(
                    nama = "Alun Alun Batu",
                    lokasi = "Kota Batu",
                    deskripsi = "Alun-alun Kota Batu menjadi destinasi wisata keluarga murah meriah. Alun-alun yang buka 24 jam ini punya konsep ramah anak.",
                    thumbnail = "https://lh3.googleusercontent.com/-R0ipuAxdPus/VpgqL1YRyRI/AAAAAAAACdI/XWkGUZpTegE/s250-Ic42/thumbnail_alun_alun_batu.jpg",
                    gambar = "https://lh3.googleusercontent.com/-bFfINcFXjFM/VpgkzblyBhI/AAAAAAAACbg/r6z0tBnCBMY/s800-Ic42/alun_alun_batu.jpg"
                ),
                PlaceModel(
                    nama = "Gunung Bromo",
                    lokasi = "Kab. Malang",
                    deskripsi = "Gunung ini memiliki ketinggian 2.329 meter di atas permukaan laut dan berada dalam empat wilayah kabupaten.",
                    thumbnail = "https://lh3.googleusercontent.com/-3ZeMDlvAbTw/VqWeZyHYbdI/AAAAAAAAChk/P2WFYWhHtMc/s250-Ic42/thumbnail_gunung_bromo.jpg",
                    gambar = "https://lh3.googleusercontent.com/-hrZPvs0iuhw/VqWec-d81kI/AAAAAAAAChs/Bl1v4J2fvh4/s800-Ic42/gunung_bromo.jpg"
                ),
                PlaceModel(
                    nama = "Jatim Park 1",
                    lokasi = "Kota Batu",
                    deskripsi = "Obyek wisata ini memiliki 36 wahana, diantaranya kolam renang raksasa, spinning coaster, dan drop zone.",
                    thumbnail = "https://lh3.googleusercontent.com/-dXQZBPwxpyw/VpgqOJlOudI/AAAAAAAACdo/RjUPX5853kU/s250-Ic42/thumbnail_jatim_park_1.jpg",
                    gambar = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/bc4f8d86-6790-4e4a-950f-0ef74d0ad174/ddjf2sr-e19fa7cf-1675-4398-b061-c4706f188373.jpg"
                )
            )
        )
    }
}
