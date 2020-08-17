package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *   Created by quangnv on 10/03/2019
 */

open class DeleteMovieUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<DeleteMovieUseCase.Params, Flow<Boolean>>() {
    override fun createFlow(params: Params?): Flow<Boolean> {
        params?.apply {
            return movieRepository.deleteMovie(params.movie)
        }
        return flow { emit(false) }
    }

    data class Params(val movie: Movie)
}