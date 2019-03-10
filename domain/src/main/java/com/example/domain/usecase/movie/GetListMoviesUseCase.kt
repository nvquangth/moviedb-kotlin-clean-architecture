package com.example.domain.usecase.movie

import com.example.domain.Constants
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Single

/**
 *   Created by quangnv on 10/03/2019
 */

open class GetListMoviesUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<GetListMoviesUseCase.Params?, Single<MutableList<Movie>>>() {
    override fun createObservable(params: Params?): Single<MutableList<Movie>> {
        params?.apply {
            return movieRepository.getMovies(params.fromServer)
        }
        return Single.error(Throwable(Constants.PARAMS_ERROR))
    }

    override fun onCleared() {
        // if you want to subscribe in UseCase
        // please unSubscribe it
    }

    data class Params(val fromServer: Boolean)
}