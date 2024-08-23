package com.dulllife

fun main() {
    println("Hello World!")
    val server = DaggerUncleApps.create().server()
    server.run()
}