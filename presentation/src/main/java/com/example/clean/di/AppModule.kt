package com.example.clean.di

import com.clean.data.di.entityMapperModule
import com.clean.data.di.networkModule
import com.clean.data.di.repositoryModule
import com.example.domain.di.useCaseModule
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {
    single { androidApplication().resources }
}

val modules = listOf(
    viewModelModule,
    itemMapperModule,
    rxModule,
    appModule,
    repositoryModule,
    useCaseModule,
    networkModule,
    entityMapperModule
)