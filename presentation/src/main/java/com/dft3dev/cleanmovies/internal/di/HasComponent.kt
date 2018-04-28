package com.dft3dev.cleanmovies.internal.di

/**
 * Created by david on 28/4/18.
 *
 * Interface representing a contract for clients that contains a component for dependency injection
 */
interface HasComponent<C> {

    fun getComponent(): C
}