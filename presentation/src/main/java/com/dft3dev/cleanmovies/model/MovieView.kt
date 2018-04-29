package com.dft3dev.cleanmovies.model

/**
 * Created by david on 28/4/18.
 */
data class MovieView(
        val adult: Boolean,
        val backdropPath: String,
        val genres: List<GenreView>?,
        val id: Int,
        val originalLanguage: String,
        val originalTitle: String,
        val overview: String,
        val posterPath: String,
        val releaseDate: String,
        val title: String,
        val voteAverage: Float,
        val voteCount: Int
)