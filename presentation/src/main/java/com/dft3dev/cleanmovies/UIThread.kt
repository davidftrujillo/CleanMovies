package com.dft3dev.cleanmovies

import com.dft3dev.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by david on 28/4/18.
 */
@Singleton
class UIThread @Inject constructor(): PostExecutionThread {

    override fun getScheduler(): Scheduler {

        return AndroidSchedulers.mainThread()
    }
}