package com.dft3dev.data.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.dft3dev.data.model.GenreEntity

@Dao
interface MovieGenreJoinDao {

    @Query("SELECT * FROM genre INNER JOIN movie_genre ON genre.id=movie_genre.genreId WHERE movie_genre.movieId=:movieId")
    fun getGenreForMovie(movieId: String): GenreEntity
}