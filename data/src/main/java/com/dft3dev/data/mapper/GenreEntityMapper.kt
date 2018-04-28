package com.dft3dev.data.mapper

import com.dft3dev.data.model.GenreEntity
import com.dft3dev.domain.Genre

/**
 * Created by david on 27/4/18.
 */
class GenreEntityMapper {

    fun map(genre: GenreEntity): Genre {

        return Genre(genre.id, genre.name)
    }

    fun mapCollection(genres: Collection<GenreEntity>): Collection<Genre> {

        val genreList = ArrayList<Genre>()

        genres.mapNotNullTo(genreList) { map(it) }

        return genreList
    }
}