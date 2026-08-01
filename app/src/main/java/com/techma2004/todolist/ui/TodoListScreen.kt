package com.techma2004.todolist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoListScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Encrypted Todo & Notepad") }) },
        content = { padding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {
                Text("This is a scaffold. Hook up ViewModel + DB to show todos.", modifier = Modifier.padding(16.dp))
                Button(onClick = { /* open add dialog */ }, modifier = Modifier.padding(16.dp)) {
                    Text("Add Todo")
                }
            }
        }
    )
}
