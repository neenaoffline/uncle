package com.dulllife.repository

import com.dulllife.dao.Advice
import com.dulllife.dao.AdviceTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Random
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class UncleRepo @Inject constructor(private val db: Database) {
    fun addAdvice(advice: String) {
        println("addingAdvice received: ${advice}.")
        transaction {
            AdviceTable.insert {
                it[AdviceTable.adviceText] = advice.trim()
            }
        }

        println("addAdvice received: ${advice}.")
    }

    fun getAdvice(): String {
        var advice: String = ""
        transaction {
            advice = AdviceTable.selectAll()
                .orderBy(Random())
                .limit(1)
                .map {
                    it[AdviceTable.adviceText]
                }
                .toList()
                .first()
            println("getAdvice received: ${advice}.")
        }
        return advice
    }
}