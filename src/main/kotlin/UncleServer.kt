package com.dulllife

import com.dulllife.components.DaggerUncleHandlers
import com.dulllife.components.UncleHandlers
import com.dulllife.logging.UncleLogger
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import javax.inject.Inject

class UncleServer @Inject constructor(private val logger: UncleLogger) {
    fun run() {
        logger.log("Starting Uncle Server")
        embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
            this.setupServer()
        }.start(wait = true)
    }
}

fun Application.configureRouting(handlers: UncleHandlers) {
    routing {
        get("/advice") { handlers.adviceHandler().getAdvice(call) }
        post("/advice") { handlers.adviceHandler().addAdvice(call) }
    }
}

fun Application.setupServer() {
    configureRouting(DaggerUncleHandlers.create())
}