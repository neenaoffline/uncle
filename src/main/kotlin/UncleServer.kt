package com.dulllife

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import javax.inject.Inject

class UncleServer @Inject constructor(private val logger: UncleLogger) {
    fun run() {
        logger.log("Starting Uncle Server")
        embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
            module()
        }.start(wait = true)
    }
}

fun Application.configureRouting(handlers: UncleHandlers) {
    routing {
        get("/advice") { handlers.adviceHandler().getAdvice(call) }
    }
}

fun Application.module() {
    configureRouting(DaggerUncleHandlers.create())
}