package com.dft3dev.data.model.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.dft3dev.data.model.GenreEntity

@Dao
interface GenreDao {

    @Query("SELECT * FROM Genre")
    fun getAll(): List<GenreEntity>

    @Query("SELECT * FROM Genre WHERE id = :id")
    fun findById(id: Int): GenreEntity
}