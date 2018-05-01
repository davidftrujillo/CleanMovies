package com.dft3dev.domain

/**
 * Created by david on 26/4/18.
 */
data class Movie(
        val adult: Boolean,
        val backdropPath: String?,
        val genres: List<Genre>?,
        val id: Int,
        val originalLanguage: String,
        val originalTitle: String,
        val overview: String,
        val posterPath: String?,
        val releaseDate: String,
        val title: String,
        val voteAverage: Float,
        val voteCount: Int
)