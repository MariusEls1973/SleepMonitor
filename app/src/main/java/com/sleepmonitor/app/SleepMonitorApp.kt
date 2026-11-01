package com.sleepmonitor.app

import android.app.Application
import com.sleepmonitor.app.data.AppDatabase

class SleepMonitorApp : Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
}
