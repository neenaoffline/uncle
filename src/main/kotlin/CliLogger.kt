package com.dulllife

class CliLogger: UncleLogger {
    override fun log(msg: String) {
        println(msg)
    }
}