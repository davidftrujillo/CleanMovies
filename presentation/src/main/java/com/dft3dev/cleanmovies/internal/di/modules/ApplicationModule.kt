package com.dft3dev.cleanmovies.internal.di.modules

import android.app.Application
import android.content.Context
import com.dft3dev.cleanmovies.UIThread
import com.dft3dev.data.executor.JobExecutor
import com.dft3dev.data.model.database.dao.MovieDao
import com.dft3dev.data.repository.MovieDataRepository
import com.dft3dev.domain.executor.PostExecutionThread
import com.dft3dev.domain.executor.ThreadExecutor
import com.dft3dev.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by david on 28/4/18.
 *
 * Dagger module that provides objects which will live during the application lifecycle
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application {
        return this.application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return this.application.applicationContext
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideMovieRepository(movieDataRepository: MovieDataRepository): MovieRepository {
        return movieDataRepository
    }
}