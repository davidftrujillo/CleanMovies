package com.dft3dev.domain.repository

import com.dft3dev.domain.Movie
import io.reactivex.Observable

/**
 * Created by david on 27/4/18.
 *
 * Interface that represents a Repository for getting {@link Movie} related data
 */
interface MovieRepository {

    fun getMovie(id: Int): Observable<Movie>

    fun getUpcoming(): Observable<List<Movie>>
}