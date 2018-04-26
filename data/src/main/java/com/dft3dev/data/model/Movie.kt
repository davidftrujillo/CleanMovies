package com.dft3dev.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by david on 26/4/18.
 */
data class Movie(
        val adult: Boolean,
        @SerializedName("backdrop_path") val backdropPath: String,
        val genres: List<Genre>,
        val id: Int,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        val overview: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("release_date") val releaseDate: String,
        val title: String,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("vote_count") val voteCount: Int
)