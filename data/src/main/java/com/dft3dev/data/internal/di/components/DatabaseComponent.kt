package com.dft3dev.data.internal.di.components

import com.dft3dev.data.internal.di.modules.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(DatabaseModule::class)])
interface DatabaseComponent {

}