package com.dulllife

import dagger.Component
import javax.inject.Singleton

@Component(modules = [UncleModule::class])
@Singleton
interface UncleHandlers {
    fun adviceHandler(): AdviceHandler
}