package com.dft3dev.data.repository.datasource

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.network.ApiService
import com.dft3dev.data.network.DaggerNetworkComponent
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class RemoteMovieDataSource @Inject constructor(val retrofit: Retrofit): MovieDataSource {

//    @Inject lateinit var retrofit: Retrofit

    override fun getMovie(id: Int): Observable<MovieEntity> {

        DaggerNetworkComponent.builder().build().inject(this)
        return retrofit.create(ApiService::class.java).getMovieById(id)
//        return ApiClient().apiService()!!.getMovieById(id)
//        return apiService.getMovieById(id).doOnNext(/* Save into local storage */)
    }
}