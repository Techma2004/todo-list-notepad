package com.techma2004.todolist.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val todoId: Long?,
    val content: String,
    val updatedAt: Long = System.currentTimeMillis()
)
