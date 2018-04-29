package com.dft3dev.cleanmovies.internal.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by david on 28/4/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity