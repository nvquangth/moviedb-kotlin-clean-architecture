package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *   Created by quangnv on 10/03/2019
 */

open class GetMovieDetailUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<GetMovieDetailUseCase.Params?, Flow<Movie?>>() {
    override fun createFlow(params: Params?): Flow<Movie?> {
        params?.apply {
            return movieRepository.getMovie(params.movieId, params.fromServer)
        }
        return flow { emit(null) }
    }

    data class Params(val movieId: Int, val fromServer: Boolean)
}