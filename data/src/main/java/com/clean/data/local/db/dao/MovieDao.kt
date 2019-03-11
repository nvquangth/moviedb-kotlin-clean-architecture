package com.clean.data.local.db.dao

import androidx.room.*
import com.clean.data.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {

    @Insert
    fun insert(movie: MovieEntity): Completable

    @Update
    fun update(movie: MovieEntity): Completable

    @Delete
    fun delete(movie: MovieEntity): Completable

    @Query("SELECT * FROM movie")
    fun getMovies(): Single<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovie(id: Int): Single<MovieEntity>
}