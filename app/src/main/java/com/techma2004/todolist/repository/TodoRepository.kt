package com.techma2004.todolist.repository

import android.content.Context
import com.techma2004.todolist.db.AppDatabase
import com.techma2004.todolist.db.Note
import com.techma2004.todolist.db.Todo

class TodoRepository(private val context: Context) {
    private val db by lazy { AppDatabase.getInstance(context) }

    suspend fun getAll(): List<Todo> = db.todoDao().getAll()
    suspend fun insert(todo: Todo): Long = db.todoDao().insert(todo)
    suspend fun update(todo: Todo) = db.todoDao().update(todo)
    suspend fun delete(todo: Todo) = db.todoDao().delete(todo)

    suspend fun getNotesFor(todoId: Long?): List<Note> = db.noteDao().getForTodo(todoId)
    suspend fun insertNote(note: Note): Long = db.noteDao().insert(note)
}
