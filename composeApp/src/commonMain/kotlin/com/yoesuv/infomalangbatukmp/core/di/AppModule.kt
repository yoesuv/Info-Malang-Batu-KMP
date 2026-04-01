package com.yoesuv.infomalangbatukmp.core.di

import com.yoesuv.infomalangbatukmp.core.network.GalleryApiService
import com.yoesuv.infomalangbatukmp.core.network.GalleryApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.network.PinsApiService
import com.yoesuv.infomalangbatukmp.core.network.PinsApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiService
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepository
import com.yoesuv.infomalangbatukmp.core.repository.ChangelogRepositoryImpl
import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepository
import com.yoesuv.infomalangbatukmp.core.repository.GalleryRepositoryImpl
import com.yoesuv.infomalangbatukmp.core.repository.LibrariesRepository
import com.yoesuv.infomalangbatukmp.core.repository.LibrariesRepositoryImpl
import com.yoesuv.infomalangbatukmp.core.repository.PinsRepository
import com.yoesuv.infomalangbatukmp.core.repository.PinsRepositoryImpl
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepository
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepositoryImpl
import com.yoesuv.infomalangbatukmp.feature.about.ChangelogViewModel
import com.yoesuv.infomalangbatukmp.feature.about.LibrariesViewModel
import com.yoesuv.infomalangbatukmp.feature.gallery.GalleryViewModel
import com.yoesuv.infomalangbatukmp.feature.listplace.ListPlaceViewModel
import com.yoesuv.infomalangbatukmp.feature.maps.MapsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single<PlaceApiService> { PlaceApiServiceImpl() }
    single<GalleryApiService> { GalleryApiServiceImpl() }
    single<PinsApiService> { PinsApiServiceImpl() }
}

val repositoryModule = module {
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
    single<GalleryRepository> { GalleryRepositoryImpl(get()) }
    single<PinsRepository> { PinsRepositoryImpl(get()) }
    single<ChangelogRepository> { ChangelogRepositoryImpl() }
    single<LibrariesRepository> { LibrariesRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { ListPlaceViewModel(get()) }
    viewModel { GalleryViewModel(get()) }
    viewModel { MapsViewModel(get()) }
    viewModel { ChangelogViewModel(get()) }
    viewModel { LibrariesViewModel(get()) }
}

val appModule = listOf(networkModule, repositoryModule, viewModelModule)