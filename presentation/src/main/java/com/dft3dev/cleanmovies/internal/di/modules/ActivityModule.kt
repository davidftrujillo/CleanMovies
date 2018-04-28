package com.dft3dev.cleanmovies.internal.di.modules

import android.app.Activity
import com.dft3dev.cleanmovies.internal.di.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by david on 28/4/18.
 *
 * A module to wrap the Activity state and expose it to the graph
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    fun activity(): Activity {
        return this.activity
    }
}