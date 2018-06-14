package com.dft3dev.data.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dft3dev.data.model.GenreEntity
import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.MovieGenre
import com.dft3dev.data.model.database.dao.GenreDao
import com.dft3dev.data.model.database.dao.MovieDao
import com.dft3dev.data.model.database.dao.MovieGenreJoinDao

@Database(entities = [GenreEntity::class, MovieEntity::class, MovieGenre::class], version = 5)
@TypeConverters(Converters::class)
abstract class CleanMovieDatabase: RoomDatabase() {

    abstract fun genreDao(): GenreDao

    abstract fun movieDao(): MovieDao

    abstract fun genreMovieJoinDao(): MovieGenreJoinDao
}