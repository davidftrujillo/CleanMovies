package com.dft3dev.data.mapper

import com.dft3dev.data.model.MovieEntity
import com.dft3dev.domain.Genre
import com.dft3dev.domain.Movie
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by david on 27/4/18.
 */
@Singleton
class MovieEntityMapper @Inject constructor() {

    fun map(movie: MovieEntity): Movie {

        return Movie(movie.adult, movie.backdropPath, GenreEntityMapper().mapCollection(emptyList()/*movie.genres.orEmpty()*/),
                movie.id, movie.originalLanguage, movie.originalTitle, movie.overview, movie.posterPath,
                movie.releaseDate, movie.title, movie.voteAverage, movie.voteCount)
    }

    fun mapCollection(movies: Collection<MovieEntity>): List<Movie> {

        val movieList = ArrayList<Movie>()

        movies.mapNotNullTo(movieList) { map(it) }

        return movieList
    }
}