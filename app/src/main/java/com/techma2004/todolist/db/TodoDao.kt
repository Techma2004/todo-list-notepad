package com.techma2004.todolist.db

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY dueAt IS NULL, dueAt ASC")
    suspend fun getAll(): List<Todo>

    @Insert
    suspend fun insert(todo: Todo): Long

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)
}
