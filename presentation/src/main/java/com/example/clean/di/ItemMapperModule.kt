package com.example.clean.di

import com.example.clean.model.MovieItemMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val itemMapperModule = module {
    single { create<MovieItemMapper>() }
}