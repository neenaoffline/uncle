package com.dulllife

import dagger.Component

@Component(modules = [UncleModule::class])
interface UncleApps {
    fun server(): UncleServer
}