package com.clean.data.di

import com.clean.data.model.MovieEntityMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val entityMapperModule = module {
    single { create<MovieEntityMapper>() }
}