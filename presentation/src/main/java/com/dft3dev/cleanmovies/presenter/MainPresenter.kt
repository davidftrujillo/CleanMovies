package com.dft3dev.cleanmovies.presenter

import android.util.Log
import com.dft3dev.cleanmovies.internal.di.PerActivity
import com.dft3dev.cleanmovies.mapper.MovieMapper
import com.dft3dev.cleanmovies.view.MainView
import com.dft3dev.domain.Movie
import com.dft3dev.domain.interactor.GetMovieById
import com.dft3dev.domain.interactor.GetUpcomingMovies
import io.reactivex.observers.DisposableObserver
import java.util.*
import javax.inject.Inject

/**
 * Created by david on 29/4/18.
 */
@PerActivity
class MainPresenter @Inject constructor(private val getMovieById: GetMovieById, private val getUpcomingMovies: GetUpcomingMovies,
                                        private val movieDataMapper: MovieMapper): BasePresenter {

    private var mainView: MainView? = null

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
        getMovieById.dispose()
        mainView = null
    }

    fun setView(view: MainView) {

        this.mainView = view
    }

    fun onLoadRandomMovieButtonClicked() {

        val random = Random()
        var randomId = random.nextInt(1000)

        getMovieById.execute(object : DisposableObserver<Movie>() {
            override fun onError(e: Throwable) {
                Log.d("MOVIE", "onError: " + e.message)
            }

            override fun onNext(movie: Movie) {

                mainView?.showMovieTitle(movie.title)
                mainView?.logMovie(movieDataMapper.map(movie))
            }

            override fun onComplete() {
                Log.d("MOVIE", "onComplete: ")
            }

        }, randomId)
    }

    fun onLoadUpcomingMoviesButtonClicked() {

        getUpcomingMovies.execute(object : DisposableObserver<List<Movie>>() {

            override fun onComplete() {

                Log.d("UPCOMING MOVIE", "onComplete: ")
            }

            override fun onNext(movies: List<Movie>) {

                movies.forEach { mainView?.logMovie(movieDataMapper.map(it)) }
            }

            override fun onError(e: Throwable) {
                Log.d("UPCOMING MOVIE", "onError: " + e.message)
            }
        })
    }

}