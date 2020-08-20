package com.clean.data.di

import com.clean.data.model.MovieEntityMapper
import org.koin.dsl.module

val entityMapperModule = module {
    single { MovieEntityMapper() }
}