package com.dft3dev.cleanmovies

import android.support.v7.app.AppCompatActivity
import com.dft3dev.cleanmovies.internal.di.HasComponent
import com.dft3dev.cleanmovies.internal.di.components.ApplicationComponent
import com.dft3dev.cleanmovies.internal.di.modules.ActivityModule

/**
 * Created by david on 29/4/18.
 */
abstract class BaseActivity: AppCompatActivity() {

    protected fun <C> getComponent(componentType: Class<C>): C {
        return componentType.cast((this as HasComponent<C>).getComponent())
    }

    protected fun getApplicationComponent(): ApplicationComponent {
        return (application as CleanMoviesApplication).applicationComponent
    }

    protected fun getActivityModule(): ActivityModule {
        return ActivityModule(this)
    }
}