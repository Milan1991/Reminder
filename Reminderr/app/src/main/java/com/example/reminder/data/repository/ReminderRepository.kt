package com.example.reminder.data.repository

import com.example.reminder.domain.entity.ReminderItem

object ReminderRepository {
    val items: MutableList<ReminderItem> = arrayListOf()

    val itemsMap: MutableMap<Int,ReminderItem> = mutableMapOf()

    fun getReminder(): List<ReminderItem> {
        return items
    }
     fun addItem(item: ReminderItem) {
        items.add(item)
        itemsMap[item.id] = item
    }
}