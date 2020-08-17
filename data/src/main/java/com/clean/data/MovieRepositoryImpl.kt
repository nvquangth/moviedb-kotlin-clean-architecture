package com.clean.data

import com.clean.data.local.db.AppDatabase
import com.clean.data.local.pref.PrefHelper
import com.clean.data.model.MovieEntityMapper
import com.clean.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class MovieRepositoryImpl constructor(
    private val api: MovieApi,
    private val database: AppDatabase,
    private val prefHelper: PrefHelper,
    private val mapper: MovieEntityMapper
) : MovieRepository {
    override fun getMovie(id: Int, fromServer: Boolean): Flow<Movie> {
        if (fromServer) {
            (1..2).asFlow()
            return api.getMovie(id).asFlow { mapper.mapToDomain(it) }
        }
        return database.movieDao().getMovie(id).map { mapper.mapToDomain(it) }
    }

    override fun getMovies(fromServer: Boolean, page: Int?): Single<List<Movie>> {
        if (fromServer) {
            page?.let {
                return api.getNowPlaying(page)
                    .map { response ->
                        response.result
                            ?.map { mapper.mapToDomain(it) }
                    }
            }
        }
        return database.movieDao().getMovies().map { response ->
            response.map {
                mapper.mapToDomain(it)
            }
        }
    }

    override fun insertMovie(movie: Movie): Flow<Boolean> {
        return database.movieDao().insert(mapper.mapToData(movie))
    }

    override fun deleteMovie(movie: Movie): Flow<Boolean> {
        return database.movieDao().delete(mapper.mapToData(movie))
    }

    override fun updateMovie(movie: Movie): Flow<Boolean> {
        return database.movieDao().update(mapper.mapToData(movie))
    }
}