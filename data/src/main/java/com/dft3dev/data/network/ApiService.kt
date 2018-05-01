package com.dft3dev.data.network

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.response.UpcomingMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by david on 26/4/18.
 */
interface ApiService {

    @GET("movie/{id}")
    fun getMovieById(@Path("id") id: Int): Observable<MovieEntity>

    @GET("movie/upcoming")
    fun getUpcoming(): Observable<UpcomingMoviesResponse>
}