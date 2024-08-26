package com.dulllife.dao

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object AdviceTable: IdTable<Int>("advice") {
    override val id: Column<EntityID<Int>> = integer("id").entityId()
    val adviceText = varchar("advice_text", 1024)

    override val primaryKey = PrimaryKey(id)
}

class Advice(id: EntityID<Int>) : IntEntity(id) {
    companion object : EntityClass<Int, Advice>(AdviceTable)
    var adviceText by AdviceTable.adviceText
}