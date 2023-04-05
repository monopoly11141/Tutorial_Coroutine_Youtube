package com.example.tutorial_coroutine_youtube

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tutorial_coroutine_youtube.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            withTimeout(1000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.d(TAG, "Result when j = ${i}: ${fib(i)}")
                    }
                }

            }
            Log.d(TAG, "Ended")

        }

    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}