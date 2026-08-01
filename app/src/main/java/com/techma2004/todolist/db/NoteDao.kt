package com.techma2004.todolist.db

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE todoId = :todoId ORDER BY updatedAt DESC")
    suspend fun getForTodo(todoId: Long?): List<Note>

    @Insert
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}
