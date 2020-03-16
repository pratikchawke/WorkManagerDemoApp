package com.pratik.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var singleTaskResult : TextView
    companion object{
        val KEY_INPUT_TEXT = "key_input_text"
        val KEY_OUTPUT_TEXT = "key_output_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleTaskResult = findViewById(R.id.singleTaskResult)

    }

    fun performSingleTask(view: View) {
        val data = Data.Builder()
            .putString(KEY_INPUT_TEXT,"This is OneTimeTaskRequest !!!")
            .build()

        val singleTask = OneTimeWorkRequest.Builder(OneTimeTaskWorker::class.java)
            .setInputData(data)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(singleTask)

        WorkManager.getInstance(applicationContext).getWorkInfoByIdLiveData(singleTask.id)
            .observe(this, Observer { workinfo ->
                if (workinfo!=null){

                    if(workinfo.state.isFinished){
                        val outputData = workinfo.outputData.getString(KEY_OUTPUT_TEXT)
                        singleTaskResult.append(outputData+"\n")
                    }

                    singleTaskResult.append(workinfo.state.name+"\n")
                }
            })

    }
    fun performPeriodicTask(view: View) {
        val periodicTask = PeriodicWorkRequest.Builder(PeriodicTaskWorker::class.java,16,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(periodicTask)
    }
}
