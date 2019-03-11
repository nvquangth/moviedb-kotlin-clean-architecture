package com.clean.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.clean.data.model.base.EntityMapper
import com.clean.data.model.base.ModelEntity
import com.example.domain.model.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("vote_average")
    val vote: Float? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("overview")
    val overview: String? = null
) : ModelEntity()

class MovieEntityMapper : EntityMapper<Movie, MovieEntity> {
    override fun mapToDomain(entity: MovieEntity) = Movie(
        id = entity.id,
        title = entity.title,
        vote = entity.vote,
        posterPath = entity.posterPath,
        backdropPath = entity.backdropPath,
        overview = entity.overview
    )

    override fun mapToEntity(model: Movie) = MovieEntity(
        id = model.id,
        title = model.title,
        vote = model.vote,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview
    )
}