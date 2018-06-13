package com.dft3dev.data.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.dft3dev.data.model.GenreEntity

@Dao
interface GenreDao {

    @Query("SELECT * FROM Genre")
    fun getAll(): List<GenreEntity>

    @Query("SELECT * FROM Genre WHERE id = :id")
    fun findById(id: Int): GenreEntity

    @Insert(onConflict = REPLACE)
    fun insert(genre: GenreEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(genres: List<GenreEntity>)
}