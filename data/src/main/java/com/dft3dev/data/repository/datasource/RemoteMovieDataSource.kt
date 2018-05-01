package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.response.UpcomingMoviesResponse
import com.dft3dev.data.network.ApiService
import com.dft3dev.data.network.DaggerNetworkComponent
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class RemoteMovieDataSource @Inject constructor(val retrofit: Retrofit): MovieDataSource {

    override fun getMovie(id: Int): Observable<MovieEntity> {

        DaggerNetworkComponent.builder().build().inject(this)
        return retrofit.create(ApiService::class.java).getMovieById(id)
    }

    override fun getUpcoming(): Observable<UpcomingMoviesResponse> {

        DaggerNetworkComponent.builder().build().inject(this)
        return retrofit.create(ApiService::class.java).getUpcoming()
    }
}