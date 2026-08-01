package com.techma2004.todolist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.techma2004.todolist.db.Todo
import com.techma2004.todolist.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = TodoRepository(application.applicationContext)

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos

    init {
        loadTodos()
    }

    fun loadTodos() {
        viewModelScope.launch {
            _todos.value = repo.getAll()
        }
    }

    fun addSample() {
        viewModelScope.launch {
            repo.insert(Todo(title = "Sample Task", description = "Tap to edit", dueAt = null))
            loadTodos()
        }
    }
}
