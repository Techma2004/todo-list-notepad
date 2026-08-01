package com.techma2004.todolist.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.techma2004.todolist.R

class NextTodoWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        val intent = Intent(context, com.techma2004.todolist.MainActivity::class.java)
        val pending = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val views = RemoteViews(context.packageName, R.layout.widget_next_todo)
        views.setOnClickPendingIntent(R.id.widget_root, pending)

        // Placeholder content — in a full implementation query DB for the next todo
        views.setTextViewText(R.id.widget_title, "Next: (none)")

        val thisWidget = ComponentName(context, NextTodoWidget::class.java)
        appWidgetManager.updateAppWidget(thisWidget, views)
    }
}
