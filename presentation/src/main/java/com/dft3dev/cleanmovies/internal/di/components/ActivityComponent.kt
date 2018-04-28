package com.dft3dev.cleanmovies.internal.di.components

import android.app.Activity
import com.dft3dev.cleanmovies.internal.di.PerActivity
import com.dft3dev.cleanmovies.internal.di.modules.ActivityModule
import dagger.Component

/**
 * Created by david on 28/4/18.
 *
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation {@link PerActivity}
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    // Exposed to sub-graphs
    fun activity(): Activity
}