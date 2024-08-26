package com.dulllife.logging

class CliLogger: UncleLogger {
    override fun log(msg: String) {
        println(msg)
    }
}