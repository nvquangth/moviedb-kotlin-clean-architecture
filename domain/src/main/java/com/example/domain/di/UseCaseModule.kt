package com.example.domain.di

import com.example.domain.usecase.movie.DeleteMovieUseCase
import com.example.domain.usecase.movie.GetListMoviesUseCase
import com.example.domain.usecase.movie.GetMovieDetailUseCase
import com.example.domain.usecase.movie.InsertMovieUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

/**
 *   Created by quangnv on 10/03/2019
 */

val useCaseModule = module {
    single { create<DeleteMovieUseCase>() }
    single { create<InsertMovieUseCase>() }
    single { create<DeleteMovieUseCase>() }
    single { create<GetMovieDetailUseCase>() }
    single { create<GetListMoviesUseCase>() }
}