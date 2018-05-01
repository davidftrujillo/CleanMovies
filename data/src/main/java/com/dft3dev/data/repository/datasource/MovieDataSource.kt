package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.response.UpcomingMoviesResponse
import io.reactivex.Observable

/**
 * Created by david on 27/4/18.
 *
 * Interface defining methods for the data operations related to Movies. This needs to be implemented
 * by any data source layers, setting the requirements for the operations that need to be implemented
 */
interface MovieDataSource {

    fun getMovie(id: Int): Observable<MovieEntity>

    fun getUpcoming(): Observable<UpcomingMoviesResponse>
}