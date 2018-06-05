package com.dft3dev.data.network

import com.dft3dev.data.repository.datasource.RemoteMovieDataSource
import dagger.Component
import javax.inject.Singleton

/**
 * Created by david on 28/4/18.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface NetworkComponent {

    fun inject(remoteMovieDataSource: RemoteMovieDataSource)
}