package com.example.domain.usecase.movie

import com.example.domain.Constants
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Single

/**
 *   Created by quangnv on 10/03/2019
 */

open class GetMovieDetailUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<GetMovieDetailUseCase.Params?, Single<Movie>>() {
    override fun createObservable(params: Params?): Single<Movie> {
        params?.apply {
            return movieRepository.getMovie(params.movieId, params.fromServer)
        }
        return Single.error { Throwable(Constants.PARAMS_ERROR) }
    }

    override fun onCleared() {
        // if you want to subscribe in UseCase
        // please unSubscribe it
    }

    data class Params(val movieId: Int, val fromServer: Boolean)
}