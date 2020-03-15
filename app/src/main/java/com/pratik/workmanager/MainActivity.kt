package com.pratik.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun performSingleTask(view: View) {
        val singleTask = OneTimeWorkRequest.Builder(OneTimeTaskWorker::class.java).build()
        WorkManager.getInstance(applicationContext).enqueue(singleTask)
    }
    fun performPeriodicTask(view: View) {
        val periodicTask = PeriodicWorkRequest.Builder(PeriodicTaskWorker::class.java,16,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(periodicTask)
    }
}
