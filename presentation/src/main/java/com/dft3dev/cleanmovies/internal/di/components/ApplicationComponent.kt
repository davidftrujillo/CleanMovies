package com.dft3dev.cleanmovies.internal.di.components

import android.app.Activity
import android.content.Context
import com.dft3dev.cleanmovies.internal.di.modules.ApplicationModule
import com.dft3dev.data.network.ApiService
import com.dft3dev.data.network.NetworkComponent
import com.dft3dev.domain.executor.PostExecutionThread
import com.dft3dev.domain.executor.ThreadExecutor
import com.dft3dev.domain.repository.MovieRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 28/4/18.
 *
 * A component whose lifetime is the life of the application
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(activity: Activity)

    // Exposed to sub-graphs
    fun context(): Context
    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread(): PostExecutionThread
    fun movieRepository(): MovieRepository
}