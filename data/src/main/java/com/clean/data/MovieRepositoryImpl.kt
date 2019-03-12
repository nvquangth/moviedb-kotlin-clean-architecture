package com.clean.data

import com.clean.data.local.db.AppDatabase
import com.clean.data.local.pref.PrefHelper
import com.clean.data.model.MovieEntityMapper
import com.clean.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single

class MovieRepositoryImpl constructor(
    private val api: MovieApi,
    private val database: AppDatabase,
    private val prefHelper: PrefHelper,
    private val mapper: MovieEntityMapper
) : MovieRepository {
    override fun getMovie(id: Int, fromServer: Boolean): Single<Movie> {
        if (fromServer) {
            return api.getMovie(id).map { mapper.mapToDomain(it) }
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

    override fun insertMovie(movie: Movie): Completable {
        return database.movieDao().insert(mapper.mapToEntity(movie))
    }

    override fun deleteMovie(movie: Movie): Completable {
        return database.movieDao().delete(mapper.mapToEntity(movie))
    }

    override fun updateMovie(movie: Movie): Completable {
        return database.movieDao().update(mapper.mapToEntity(movie))
    }
}