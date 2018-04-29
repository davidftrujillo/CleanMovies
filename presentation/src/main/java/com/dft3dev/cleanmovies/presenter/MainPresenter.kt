package com.dft3dev.cleanmovies.presenter

import com.dft3dev.cleanmovies.internal.di.PerActivity
import com.dft3dev.cleanmovies.mapper.MovieMapper
import com.dft3dev.cleanmovies.view.MainView
import com.dft3dev.domain.Movie
import com.dft3dev.domain.interactor.GetMovieById
import io.reactivex.observers.DisposableObserver
import java.util.*
import javax.inject.Inject

/**
 * Created by david on 29/4/18.
 */
@PerActivity
class MainPresenter @Inject constructor(private val getMovieById: GetMovieById, private val movieDataMapper: MovieMapper): BasePresenter {

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

    fun onLoadRandomeMovieButtonClicked() {

        val random = Random()
        val randomId = random.nextInt(1000)

        getMovieById.execute(object : DisposableObserver<Movie>() {
            override fun onError(e: Throwable) {
            }

            override fun onNext(movie: Movie) {

                mainView?.showMovieTitle(movie.title)
                mainView?.logMovie(MovieMapper().map(movie))
            }

            override fun onComplete() {
            }

        }, randomId)
    }

}