package com.dulllife

import javax.inject.Inject

class UncleServer @Inject constructor(private val logger: UncleLogger) {
    fun run() {
        logger.log("Starting Uncle Server")
    }
}