package com.dft3dev.cleanmovies.view

import com.dft3dev.cleanmovies.model.MovieView

/**
 * Created by david on 29/4/18.
 */
interface MainView: LoadDataView {

    fun showMovieTitle(title: String)

    fun logMovie(movie: MovieView)
}