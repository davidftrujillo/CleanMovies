package com.dft3dev.cleanmovies.mapper

import com.dft3dev.cleanmovies.model.GenreView
import com.dft3dev.domain.Genre
import javax.inject.Inject

/**
 * Created by david on 28/4/18.
 */
class GenreMapper @Inject constructor(): Mapper<GenreView, Genre>{

    override fun map(genre: Genre): GenreView {

        return GenreView(genre.id, genre.name)
    }

    override fun mapCollection(genres: List<Genre>?): List<GenreView>? {

        var genreViews: List<GenreView>? = null

        if (genres?.orEmpty()!!.isNotEmpty()) {

            genreViews = ArrayList()

            genres?.mapTo(genreViews) { map(it) }
        }

        return genreViews
    }
}