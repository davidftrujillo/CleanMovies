package com.dft3dev.data.repository

import com.dft3dev.data.mapper.MovieEntityMapper
import com.dft3dev.data.model.MovieEntity
import com.dft3dev.data.model.database.dao.MovieDao
import com.dft3dev.data.repository.datasource.MovieDataStoreFactory
import com.dft3dev.data.repository.datasource.RemoteMovieDataSource
import com.dft3dev.domain.Movie
import com.dft3dev.domain.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class MovieDataRepository @Inject constructor(
        private val factory: MovieDataStoreFactory,
        private val movieMapper: MovieEntityMapper,
        private val movieDao: MovieDao): MovieRepository {

    override fun getMovie(id: Int): Observable<Movie> {

        val dataSource = factory.getDataSource()

        return dataSource.getMovie(id)
                .flatMap {

                    if (dataSource is RemoteMovieDataSource) {
                        saveMovie(it).toSingleDefault(it).toObservable()
                    } else {
                        Observable.just(it)
                    }
                }
                .map {
                    this.movieMapper.map(it)
                }
    }

    override fun getUpcoming(): Observable<List<Movie>> {

        val dataSource = factory.getRemoteDataSource()

        return dataSource.getUpcoming()
                .flatMap {
                    saveMovies(it.results).toSingleDefault(it).toObservable()
                }
                .map {
                    this.movieMapper.mapCollection(it.results)
                }
    }

    private fun saveMovies(movies: List<MovieEntity>): Completable {


        for (movie in movies) {
            movieDao.insert(movie)
        }

        return Completable.complete()
    }

    private fun saveMovie(movie: MovieEntity): Completable {

        movieDao.insert(movie)

        return Completable.complete()
    }
}

