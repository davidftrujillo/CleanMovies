package com.dft3dev.cleanmovies.view

import android.content.Context

/**
 * Created by david on 29/4/18.
 */
interface LoadDataView {

    fun showLoading()

    fun hideLoading()

    fun context(): Context
}