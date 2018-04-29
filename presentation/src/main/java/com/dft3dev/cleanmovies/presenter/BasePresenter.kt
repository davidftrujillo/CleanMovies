package com.dft3dev.cleanmovies.presenter

/**
 * Created by david on 29/4/18.
 */
interface BasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    fun destroy()
}