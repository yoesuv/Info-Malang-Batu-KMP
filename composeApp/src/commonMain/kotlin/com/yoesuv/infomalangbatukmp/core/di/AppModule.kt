package com.yoesuv.infomalangbatukmp.core.di

import com.yoesuv.infomalangbatukmp.core.network.GalleryApiService
import com.yoesuv.infomalangbatukmp.core.network.GalleryApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiService
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepository
import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepositoryImpl
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepository
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepositoryImpl
import com.yoesuv.infomalangbatukmp.feature.gallery.GalleryViewModel
import com.yoesuv.infomalangbatukmp.feature.listplace.ListPlaceViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single<PlaceApiService> { PlaceApiServiceImpl() }
    single<GalleryApiService> { GalleryApiServiceImpl() }
}

val repositoryModule = module {
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
    single<GalleryRepository> { GalleryRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { ListPlaceViewModel(get()) }
    viewModel { GalleryViewModel(get()) }
}

val appModule = listOf(networkModule, repositoryModule, viewModelModule)