package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *   Created by quangnv on 10/03/2019
 */

open class GetListMoviesUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<GetListMoviesUseCase.Params?, Flow<List<Movie>?>>() {
    override fun createFlow(params: Params?): Flow<List<Movie>?> {
        params?.apply {
            return movieRepository.getMovies(params.fromServer, params.page)
        }

        return flow { emit(null) }
    }

    data class Params(val fromServer: Boolean, val page: Int?)
}