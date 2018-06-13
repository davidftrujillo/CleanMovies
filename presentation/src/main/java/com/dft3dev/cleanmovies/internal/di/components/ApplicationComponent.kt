package com.dft3dev.cleanmovies.internal.di.components

import android.app.Activity
import android.content.Context
import com.dft3dev.cleanmovies.internal.di.modules.ApplicationModule
import com.dft3dev.data.internal.di.modules.DatabaseModule
import com.dft3dev.data.model.database.dao.MovieDao
import com.dft3dev.data.network.ApiService
import com.dft3dev.data.network.NetworkComponent
import com.dft3dev.data.network.NetworkModule
import com.dft3dev.domain.executor.PostExecutionThread
import com.dft3dev.domain.executor.ThreadExecutor
import com.dft3dev.domain.repository.MovieRepository
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by david on 28/4/18.
 *
 * A component whose lifetime is the life of the application
 */
@Singleton
@Component(modules = [(ApplicationModule::class), (NetworkModule::class), (DatabaseModule::class)])
interface ApplicationComponent {

    fun inject(activity: Activity)

    // Exposed to sub-graphs
    fun context(): Context
    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
    fun movieRepository(): MovieRepository
}