package com.pratik.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pratik.workmanager.MainActivity.Companion.KEY_INPUT_TEXT
import com.pratik.workmanager.MainActivity.Companion.KEY_OUTPUT_TEXT

class OneTimeTaskWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    val TAG = OneTimeTaskWorker::class.java.simpleName

    override fun doWork(): Result {
        val data = inputData
        val string = data.getString(KEY_INPUT_TEXT)
        Log.d(TAG, string)
        return try {
            val outputData = Data.Builder()
                .putString(KEY_OUTPUT_TEXT, "Worker task is done !!!")
                .build()
            Result.success(outputData)
        } catch (e: Exception) {
            val outputData = Data.Builder()
                .putString(KEY_OUTPUT_TEXT, e.toString())
                .build()
            Result.failure(outputData)
        }
    }


}