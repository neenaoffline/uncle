package com.dulllife.dao

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object AdviceTable: IntIdTable() {
    val adviceText = varchar("advice_text", 1024)
}

class Advice(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, Advice>(AdviceTable)
    var adviceText by AdviceTable.adviceText
}