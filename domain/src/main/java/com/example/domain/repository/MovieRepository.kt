package com.example.domain.repository

import com.example.domain.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 *   Created by quangnv on 10/03/2019
 */

interface MovieRepository {

    fun getMovie(id: Int, fromServer: Boolean): Flow<Movie>

    fun getMovies(fromServer: Boolean, page: Int?): Flow<List<Movie>>

    fun insertMovie(movie: Movie): Flow<Boolean>

    fun deleteMovie(movie: Movie): Flow<Boolean>

    fun updateMovie(movie: Movie): Flow<Boolean>
}