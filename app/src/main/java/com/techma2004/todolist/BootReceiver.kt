package com.techma2004.todolist

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.i("BootReceiver", "Device booted — rescheduling alarms if needed")
            // TODO: query DB or persisted alarms and reschedule via AlarmScheduler
            // This scaffold does not persist individual alarm metadata beyond todos; implement as needed.
        }
    }
}
