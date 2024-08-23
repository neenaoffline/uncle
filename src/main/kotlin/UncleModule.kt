package com.dulllife

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface UncleModule {
    @Binds fun bindUncleLogger(cliLogger: CliLogger): UncleLogger

    companion object {
        @Provides
        fun providesCliLogger() = CliLogger()
    }
}