package com.dft3dev.data.model.response

import com.dft3dev.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

/**
 * Created by david on 1/5/18.
 */
data class UpcomingMoviesResponse(
        val results: List<MovieEntity>,
        val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        val dates: DatesRange,
        @SerializedName("total_pages") val totalPages: Int
)