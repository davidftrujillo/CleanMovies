package com.dft3dev.cleanmovies

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dft3dev.cleanmovies.internal.di.HasComponent
import com.dft3dev.cleanmovies.internal.di.components.DaggerMovieComponent
import com.dft3dev.cleanmovies.internal.di.components.MovieComponent
import com.dft3dev.cleanmovies.model.MovieView
import com.dft3dev.cleanmovies.presenter.MainPresenter
import com.dft3dev.cleanmovies.view.MainView
import com.dft3dev.domain.interactor.GetMovieById
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, HasComponent<MovieComponent> {

    @Inject
    lateinit var presenter: MainPresenter
    var getMovieById: GetMovieById? = null
    lateinit var movieComponent: MovieComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeInjector()
    }

    override fun onPostResume() {
        super.onPostResume()

        button.setOnClickListener {

            if (presenter != null) {
                presenter.onLoadRandomMovieButtonClicked()
            }
        }

        presenter.setView(this)
    }

    private fun initializeInjector() {
        movieComponent = DaggerMovieComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()

        movieComponent.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun showLoading() {

        Log.d("MOVIE", "Start Loading...")
    }

    override fun hideLoading() {

        Log.d("MOVIE", "Finish Loading...")
    }

    override fun context(): Context {

        return this@MainActivity
    }

    override fun showMovieTitle(title: String) {

        Toast.makeText(this@MainActivity, title, Toast.LENGTH_SHORT).show()
    }

    override fun logMovie(movie: MovieView) {

        Log.d("MOVIE", movie.toString())
    }

    override fun getComponent(): MovieComponent {

        return movieComponent
    }
}
