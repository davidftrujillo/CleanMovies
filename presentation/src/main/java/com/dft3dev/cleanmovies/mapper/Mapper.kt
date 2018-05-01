package com.dft3dev.cleanmovies.mapper

import com.dft3dev.cleanmovies.model.GenreView

/**
 * Created by david on 28/4/18.
 *
 * Interface for model mappers. It provides helper methods that facilitate retrieving models
 * from outer layers
 */
interface Mapper<out V, in D> {

    fun map(type: D): V

    fun mapCollection(type: List<D>?): List<V>?
}