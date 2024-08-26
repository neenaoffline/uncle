package com.dulllife.components

import com.dulllife.handlers.AdviceHandler
import com.dulllife.modules.DatabaseModule
import com.dulllife.modules.UncleModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [UncleModule::class, DatabaseModule::class])
@Singleton
interface UncleHandlers {
    fun adviceHandler(): AdviceHandler
}