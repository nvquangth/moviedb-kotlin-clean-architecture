package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.repository.base.Repository
import io.reactivex.Completable
import io.reactivex.Single

/**
 *   Created by quangnv on 10/03/2019
 */

interface MovieRepository : Repository {

    fun getMovie(id: Int, fromServer: Boolean): Single<Movie>

    fun getMovies(fromServer: Boolean, page: Int?): Single<List<Movie>>

    fun insertMovie(movie: Movie): Completable

    fun deleteMovie(movie: Movie): Completable

    fun updateMovie(movie: Movie): Completable
}