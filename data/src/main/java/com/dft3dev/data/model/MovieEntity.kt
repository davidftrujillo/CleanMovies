package com.dft3dev.data.model

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

/**
 * Created by david on 26/4/18.
 */
@Entity(tableName = "Movie")
data class MovieEntity(
        @PrimaryKey
        var id: Int,
        var adult: Boolean,
        @SerializedName("backdrop_path") var backdropPath: String,
        @Ignore var genres: List<GenreEntity>,
        @SerializedName("genre_ids") var genreIds: List<String>,
        @SerializedName("original_language") var originalLanguage: String,
        @SerializedName("original_title") var originalTitle: String,
        var overview: String,
        @SerializedName("poster_path") var posterPath: String,
        @SerializedName("release_date") var releaseDate: String,
        var title: String,
        @SerializedName("vote_average") var voteAverage: Float,
        @SerializedName("vote_count") var voteCount: Int
) {
    constructor():this(0, false, "", ArrayList<GenreEntity>(), mutableListOf(), "", "","",
            "", "", "", 0f, 0)
}