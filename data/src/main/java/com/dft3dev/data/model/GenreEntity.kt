package com.dft3dev.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by david on 26/4/18.
 */
@Entity(tableName = "Genre")
data class GenreEntity(
        @PrimaryKey
        val id: Int,
        val name: String
)