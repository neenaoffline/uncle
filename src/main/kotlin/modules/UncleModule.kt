package com.dulllife.modules

import com.dulllife.UncleConfig
import com.dulllife.logging.CliLogger
import com.dulllife.logging.UncleLogger
import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface UncleModule {
    @Binds fun bindUncleLogger(cliLogger: CliLogger): UncleLogger

    companion object {
        @Provides
        fun providesCliLogger() = CliLogger()

        @Provides
        fun providesConfig(): UncleConfig {
            return ConfigLoaderBuilder.default()
                .addResourceSource("/config.toml")
                .build()
                .loadConfigOrThrow<UncleConfig>()
        }
    }
}