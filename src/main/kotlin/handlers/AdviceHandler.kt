package com.dulllife.handlers

import com.dulllife.logging.UncleLogger
import com.dulllife.repository.UncleRepo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdviceHandler @Inject constructor(private val logger: UncleLogger, private val uncleRepo: UncleRepo) {
    val uncleAdvice = listOf(
        "Invest in property; it's the safest bet for the future.",
        "Wake up early; successful people start their day before sunrise.",
        "Never leave the house with wet hair; you'll catch a cold.",
        "Always respect your elders, no matter what.",
        "Drink turmeric milk every night; it's good for your health.",
        "Keep some cash in hand; you never know when you'll need it.",
        "Beta, don't waste time on these gadgets, read books instead.",
        "Marriage is all about compromise; don't expect it to be easy.",
        "A government job is the most secure; aim for that.",
        "Always greet people with a smile; it opens doors.",
        "Beta, you should have a big friend circle; networking is important.",
        "Drink warm water with lemon first thing in the morning; it's good for digestion.",
        "Work hard now so you can relax later in life.",
        "Don't trust everything you see on the internet; verify the information.",
        "Beta, start saving early; compounding works wonders.",
        "Always carry an umbrella during monsoon, even if it looks sunny.",
        "Be careful with your company; you become who you hang out with.",
        "Eat almonds soaked overnight; they are good for the brain.",
        "Keep your documents in order; you never know when you'll need them.",
        "Beta, stay away from fast food; home-cooked meals are the best."
    )

    suspend fun getAdvice(call: ApplicationCall) {
        logger.log("GET /advice received: ${System.identityHashCode(this)}.")
        call.respondText(contentType = ContentType.Text.Plain, status = HttpStatusCode.OK) { "${uncleRepo.getAdvice()}\n" }
    }

    suspend fun addAdvice(call: ApplicationCall) {
        val advice = call.receiveText()
        logger.log("POST /advice received: ${advice}.")
        uncleRepo.addAdvice(advice)
    }
}