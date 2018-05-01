package com.dft3dev.domain.interactor

import com.dft3dev.domain.Movie
import com.dft3dev.domain.executor.PostExecutionThread
import com.dft3dev.domain.executor.ThreadExecutor
import com.dft3dev.domain.repository.MovieRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by david on 1/5/18.
 */
class GetUpcomingMovies @Inject constructor(private val movieRepository: MovieRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : UseCaseArgumentless<List<Movie>>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(): Observable<List<Movie>> {

        return movieRepository.getUpcoming()
    }
}