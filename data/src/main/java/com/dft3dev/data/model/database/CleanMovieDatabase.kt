package com.dft3dev.data.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dft3dev.data.model.GenreEntity
import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.database.dao.GenreDao
import com.dft3dev.data.model.database.dao.MovieDao

@Database(entities = [GenreEntity::class, MovieEntity::class], version = 2)
abstract class CleanMovieDatabase: RoomDatabase() {

    abstract fun genreDao(): GenreDao

    abstract fun movieDao(): MovieDao
}