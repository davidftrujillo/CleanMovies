package com.dft3dev.data.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.dft3dev.data.model.MovieEntity

@Dao
interface MovieDao {

    // QUERY
    @Query("SELECT * FROM Movie")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM MOVIE WHERE ID = :id")
    fun getMovieById(id: Int): MovieEntity

//    @Query("SELECT * FROM MOVIE WHERE id IN (SELECT movieId FROM MOVIE_GENRE WHERE genreId = :genreId)")
//    fun getMoviesByGenre(genreId: Int): List<MovieEntity>

    // INSERT
    @Insert(onConflict = REPLACE)
    fun insert(movie: MovieEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(vararg movies: MovieEntity)

    // UPDATE


    // DELETE
}