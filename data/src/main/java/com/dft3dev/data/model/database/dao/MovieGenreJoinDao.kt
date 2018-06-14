package com.dft3dev.data.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.dft3dev.data.model.GenreEntity
import com.dft3dev.data.model.MovieGenre

@Dao
interface MovieGenreJoinDao {

    @Query("SELECT * FROM genre INNER JOIN movie_genre ON genre.id=movie_genre.genreId WHERE movie_genre.movieId=:movieId")
    fun getGenreForMovie(movieId: String): GenreEntity

    @Insert(onConflict = REPLACE)
    fun insert(movieGenre: MovieGenre)
}