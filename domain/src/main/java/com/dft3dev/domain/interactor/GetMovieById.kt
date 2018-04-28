package com.dft3dev.domain.interactor

import com.dft3dev.domain.Movie
import com.dft3dev.domain.executor.PostExecutionThread
import com.dft3dev.domain.executor.ThreadExecutor
import com.dft3dev.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by david on 27/4/18.
 */
class GetMovieById @Inject constructor(private val movieRepository: MovieRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCase<Movie, Int>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(movieId: Int): Observable<Movie> {

        return movieRepository.getMovie(movieId)
    }
}