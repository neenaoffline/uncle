package com.dulllife.components

import com.dulllife.UncleServer
import com.dulllife.modules.DatabaseModule
import com.dulllife.modules.UncleModule
import dagger.Component
import org.flywaydb.core.Flyway
import javax.inject.Singleton

@Component(modules = [UncleModule::class, DatabaseModule::class])
@Singleton
interface UncleApps {
    fun server(): UncleServer
    fun flyway(): Flyway
}