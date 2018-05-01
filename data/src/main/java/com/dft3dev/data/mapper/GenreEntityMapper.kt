package com.dft3dev.data.mapper

import com.dft3dev.data.model.GenreEntity
import com.dft3dev.domain.Genre
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by david on 27/4/18.
 */
@Singleton
class GenreEntityMapper @Inject constructor() {

    fun map(genre: GenreEntity): Genre {

        return Genre(genre.id, genre.name)
    }

    fun mapCollection(genres: Collection<GenreEntity>): List<Genre> {

        val genreList = ArrayList<Genre>()

        genres.mapNotNullTo(genreList) { map(it) }

        return genreList
    }
}