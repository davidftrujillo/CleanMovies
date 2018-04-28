package com.dft3dev.data.network

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by david on 28/4/18.
 */
class Test {

    @Inject lateinit var retrofit: Retrofit
    var apiService: ApiService? = null

    fun apiService(): ApiService? {

        if (apiService == null) {
            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService
    }
}