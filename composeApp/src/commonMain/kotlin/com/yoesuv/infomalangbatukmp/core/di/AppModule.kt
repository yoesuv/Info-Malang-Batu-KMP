package com.yoesuv.infomalangbatukmp.core.di

import com.yoesuv.infomalangbatukmp.core.network.PlaceApiService
import com.yoesuv.infomalangbatukmp.core.network.PlaceApiServiceImpl
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepository
import com.yoesuv.infomalangbatukmp.core.repository.PlaceRepositoryImpl
import com.yoesuv.infomalangbatukmp.feature.listplace.ListPlaceViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single<PlaceApiService> { PlaceApiServiceImpl() }
}

val repositoryModule = module {
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { ListPlaceViewModel(get()) }
}

val appModule = listOf(networkModule, repositoryModule, viewModelModule)