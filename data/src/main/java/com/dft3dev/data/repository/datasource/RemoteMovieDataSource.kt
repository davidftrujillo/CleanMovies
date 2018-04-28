package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.network.ApiService
import io.reactivex.Observable

/**
 * Created by david on 27/4/18.
 */
class RemoteMovieDataSource(private val apiService: ApiService): MovieDataSource {

    override fun getMovie(id: Int): Observable<MovieEntity> {

        return apiService.getMovieById(id)
//        return apiService.getMovieById(id).doOnNext(/* Save into local storage */)
    }
}