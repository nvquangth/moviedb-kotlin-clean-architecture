package com.example.domain.model

import com.example.domain.model.base.Model

/**
 *   Created by quangnv on 10/03/2019
 */

class Movie(
    val id: Int,
    val title: String? = null,
    val vote: Float? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val overview: String? = null
) : Model()