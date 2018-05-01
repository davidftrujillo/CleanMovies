package com.dft3dev.cleanmovies.mapper

import com.dft3dev.cleanmovies.model.MovieView
import com.dft3dev.domain.Movie
import javax.inject.Inject

/**
 * Created by david on 28/4/18.
 */
class MovieMapper @Inject constructor(): Mapper<MovieView, Movie> {

    override fun map(movie: Movie): MovieView {

        return MovieView(
                movie.adult,
                movie.backdropPath.orEmpty(),
                GenreMapper().mapCollection(movie.genres),
                movie.id,
                movie.originalLanguage,
                movie.originalTitle,
                movie.overview,
                movie.posterPath.orEmpty(),
                movie.releaseDate,
                movie.title,
                movie.voteAverage,
                movie.voteCount
        )
    }

    override fun mapCollection(movies: List<Movie>?): List<MovieView>? {

        var movieViews: List<MovieView>? = null

        if (movies?.orEmpty()!!.isNotEmpty()) {

            movieViews = ArrayList()

            movies.mapTo(movieViews) { map(it) }
        }

        return movieViews
    }
}