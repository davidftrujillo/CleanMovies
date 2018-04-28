package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class LocalMovieDataSource @Inject constructor(): MovieDataSource {

    override fun getMovie(id: Int): Observable<MovieEntity> {

        // TODO search movie in local storage
        throw NotImplementedError()
    }
}