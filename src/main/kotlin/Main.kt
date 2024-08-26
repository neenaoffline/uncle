package com.dulllife

import com.dulllife.components.DaggerUncleApps
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.sqlite.SQLiteDataSource

fun main() {
    val uncleApps = DaggerUncleApps.create()
    uncleApps.flyway().migrate()

    println("Migrated. Starting server")

    val server = uncleApps.server()
    server.run()
}