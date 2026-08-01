package com.techma2004.todolist.alarms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("title") ?: "Reminder"
        val id = intent.getLongExtra("id", 0L).toInt()

        val notif = NotificationCompat.Builder(context, "todo_channel")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Todo Reminder")
            .setContentText(title)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        NotificationManagerCompat.from(context).notify(id, notif)
    }
}
