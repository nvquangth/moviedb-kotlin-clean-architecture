package com.clean.data.remote.api

import com.clean.data.model.MovieEntity
import com.clean.data.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieApi {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page: Int): MovieResponse

    @GET("/3/movie/{movie_id}")
    fun getMovie(@Path("movie_id") id: Int): MovieEntity
}