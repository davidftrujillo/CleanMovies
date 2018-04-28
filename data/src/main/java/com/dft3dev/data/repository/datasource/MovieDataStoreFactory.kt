package com.dft3dev.data.repository.datasource

import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class MovieDataStoreFactory @Inject constructor(
        private val movieLocalDataSource: LocalMovieDataSource,
        private val movieRemoteDataSource: RemoteMovieDataSource) {

    fun getDataSource(): MovieDataSource {

        // TODO implement mechanism to know if the data is available in local storage data source

        return getRemoteDataSource()
    }

    fun getLocalDataSource(): MovieDataSource {

        return movieLocalDataSource
    }

    fun getRemoteDataSource(): MovieDataSource {

        return movieRemoteDataSource
    }
}