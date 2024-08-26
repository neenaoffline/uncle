package com.dulllife.modules

import com.dulllife.logging.CliLogger
import com.dulllife.logging.UncleLogger
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