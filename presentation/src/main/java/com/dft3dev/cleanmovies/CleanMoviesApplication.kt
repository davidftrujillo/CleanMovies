package com.dft3dev.cleanmovies

import android.app.Application
import com.dft3dev.cleanmovies.internal.di.components.ApplicationComponent
import com.dft3dev.cleanmovies.internal.di.components.DaggerApplicationComponent
import com.dft3dev.cleanmovies.internal.di.modules.ApplicationModule

/**
 * Created by david on 29/4/18.
 */
class CleanMoviesApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {

        super.onCreate()
        this.initializeInjector()
    }

    private fun initializeInjector() {

        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}