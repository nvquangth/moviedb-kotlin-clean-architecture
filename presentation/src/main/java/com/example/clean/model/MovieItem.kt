package com.example.clean.model

import com.example.clean.model.base.ItemMapper
import com.example.clean.model.base.ModelItem
import com.example.domain.model.Movie

data class MovieItem(
    val id: Int,
    val title: String? = null,
    val vote: Float? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val overview: String? = null
) : ModelItem()

class MovieItemMapper : ItemMapper<Movie, MovieItem> {
    override fun mapToPresentation(model: Movie) = MovieItem(
        id = model.id,
        title = model.title,
        vote = model.vote,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview
    )

    override fun mapToDomain(modelItem: MovieItem) = Movie(
        id = modelItem.id,
        title = modelItem.title,
        vote = modelItem.vote,
        posterPath = modelItem.posterPath,
        backdropPath = modelItem.backdropPath,
        overview = modelItem.overview
    )
}