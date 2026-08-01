package com.techma2004.todolist.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val dueAt: Long?,
    val completed: Boolean = false,
    val priority: Int = 0
)
