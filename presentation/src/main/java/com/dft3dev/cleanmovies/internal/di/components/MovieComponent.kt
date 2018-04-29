package com.dft3dev.cleanmovies.internal.di.components

import com.dft3dev.cleanmovies.MainActivity
import com.dft3dev.cleanmovies.internal.di.PerActivity
import com.dft3dev.cleanmovies.internal.di.modules.ActivityModule
import com.dft3dev.cleanmovies.internal.di.modules.MovieModule
import dagger.Component

/**
 * Created by david on 28/4/18.
 *
 * A scope {@link PerActivity} component. Inject movie specifics Fragments
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class, MovieModule::class))
interface MovieComponent: ActivityComponent {

    fun inject(mainActivity: MainActivity)
}