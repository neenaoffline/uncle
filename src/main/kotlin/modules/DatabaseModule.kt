package com.dulllife.modules

import com.dulllife.UncleConfig
import dagger.Module
import dagger.Provides
import io.ktor.server.http.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.sqlite.SQLiteDataSource
import javax.inject.Singleton
import javax.sql.DataSource

@Module
interface DatabaseModule {
    companion object {
        @Provides
        fun providesDataSource(uncleConfig: UncleConfig): DataSource {
            val dataSource = SQLiteDataSource()
            dataSource.url = "jdbc:sqlite:${uncleConfig.databasePath}"
            return dataSource
        }

        @Provides
        @Singleton
        fun providesDatabase(dataSource: DataSource): Database {
            return Database.connect(dataSource)
        }


        @Provides
        @Singleton
        fun providesFlyway(dataSource: DataSource): Flyway {
            return Flyway.configure()
                .dataSource(dataSource)
                .load()
        }

    }
}