package com.example.domain.di

import com.example.domain.usecase.movie.*
import org.koin.dsl.module

/**
 *   Created by quangnv on 10/03/2019
 */

val useCaseModule = module {
    single { DeleteMovieUseCase(get()) }
    single { InsertMovieUseCase(get()) }
    single { UpdateMovieUseCase(get()) }
    single { GetMovieDetailUseCase(get()) }
    single { GetListMoviesUseCase(get()) }
}