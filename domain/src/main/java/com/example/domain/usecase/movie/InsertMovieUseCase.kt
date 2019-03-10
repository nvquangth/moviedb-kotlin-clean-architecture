package com.example.domain.usecase.movie

import com.example.domain.Constants
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Completable

/**
 *   Created by quangnv on 10/03/2019
 */

open class InsertMovieUseCase constructor(private val movieRepository: MovieRepository) :
    UseCase<InsertMovieUseCase.Params, Completable>() {
    override fun createObservable(params: Params?): Completable {
        params?.apply {
            return movieRepository.insertMovie(params.movie)
        }
        return Completable.error(Throwable(Constants.PARAMS_ERROR))
    }

    override fun onCleared() {
        // if you want to subscribe in UseCase
        // please unSubscribe it
    }

    data class Params(val movie: Movie)
}