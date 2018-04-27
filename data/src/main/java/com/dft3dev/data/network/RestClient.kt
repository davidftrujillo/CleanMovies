package com.dft3dev.data.network

import com.dft3dev.data.BuildConfig
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by david on 26/4/18.
 */
object RestClient {

    var retrofit: Retrofit? = null
    var apiService: ApiService? = null

    init {

        createRetrofit()
    }

    private fun createOkHttpClient(): OkHttpClient {

        val httpClientBuilder = OkHttpClient.Builder()

        httpClientBuilder.addInterceptor { chain ->
            val original = chain?.request()
            val originalHttpUrl = original?.url()

            val url = originalHttpUrl?.newBuilder()!!
                    .addQueryParameter("api_key", BuildConfig.TMDB_ApiKey)
                    .addQueryParameter("language", "es-ES")
                    .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder().url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return httpClientBuilder.build()
    }

    private fun createRetrofit(): Retrofit {

        retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient())
                .build()
    }
}