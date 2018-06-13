package com.dft3dev.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(
    tableName = "movie_genre",
    primaryKeys = ["movieId", "genreId"],
    foreignKeys = [(ForeignKey(entity = MovieEntity::class, parentColumns = arrayOf("id"), childColumns = arrayOf("movieId")))]
)
data class MovieGenreJoin(
        val movieId: Int,
        val genreId: Int
)