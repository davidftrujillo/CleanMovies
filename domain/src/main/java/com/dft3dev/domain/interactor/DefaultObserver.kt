package com.dft3dev.domain.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Created by david on 27/4/18.
 *
 * Default {@link DisposableObserver} base class to be use whenever you want default error handling
 */
class DefaultObserver<T>: DisposableObserver<T>() {

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }

    override fun onNext(t: T) {
    }
}