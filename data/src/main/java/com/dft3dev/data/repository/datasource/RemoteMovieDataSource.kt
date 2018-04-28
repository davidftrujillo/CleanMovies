package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.network.ApiService
import com.dft3dev.data.network.Test
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class RemoteMovieDataSource @Inject constructor(): MovieDataSource {

    override fun getMovie(id: Int): Observable<MovieEntity> {

        return Test().apiService!!.getMovieById(id)
//        return apiService.getMovieById(id).doOnNext(/* Save into local storage */)
    }
}