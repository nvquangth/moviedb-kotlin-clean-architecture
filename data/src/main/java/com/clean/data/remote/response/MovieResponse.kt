package com.clean.data.remote.response

import com.clean.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("results")
    val result: List<MovieEntity>? = null
)