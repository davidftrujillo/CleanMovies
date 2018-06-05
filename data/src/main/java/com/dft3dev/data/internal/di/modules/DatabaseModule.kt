package com.dft3dev.data.internal.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.dft3dev.data.model.database.CleanMovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): CleanMovieDatabase =
            Room.databaseBuilder(context, CleanMovieDatabase::class.java, "CleanMovieDatabase")
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @Singleton
    fun provideMovieDao(database: CleanMovieDatabase) = database.movieDao()
}