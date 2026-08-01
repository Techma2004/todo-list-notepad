package com.techma2004.todolist

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.util.Log
import com.techma2004.todolist.alarms.AlarmScheduler

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        // Note: DB is initialized lazily by AppDatabase.getInstance(context)
        // Optionally reschedule alarms here if you persist alarms separately
        Log.i("App", "Application started: notification channel created")
    }

    private fun createNotificationChannel() {
        val channelId = "todo_channel"
        val name = "Todo Reminders"
        val descriptionText = "Notifications for todo reminders"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.createNotificationChannel(channel)
    }
}
