package com.kotlin30projects.android.stopwatch

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    enum class ButtonType(val key: String) {
        START("start"),
        STOP("stop"),
        LAP("lap"),
        RESET("reset")
    }

    private val formatter = SimpleDateFormat("mm:ss.SSS")
    private val handler = Handler()
    private var prevTimeMillis: Long = 0
    private var timer: Long = 0
    private var lapTimer: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftButton.text = ButtonType.LAP.key
        rightButton.text = ButtonType.START.key

        val runnable = object : Runnable {
            override fun run() {
                val now = System.currentTimeMillis()
                val difference = now - prevTimeMillis
                timer += difference
                lapTimer += difference
                prevTimeMillis = now
                mainTimerText.text = formatter.format(timer)
                subTimerText.text = formatter.format(lapTimer)
                handler.postDelayed(this, 1)
            }
        }
        leftButton.setOnClickListener {
            if (leftButton.text == ButtonType.LAP.key) {
                ///TODO: add list.
                lapTimer = 0
            } else if (leftButton.text == ButtonType.RESET.key) {
                handler.removeCallbacks(runnable)
                timer = 0
                lapTimer = 0
                val initializedFormatText = formatter.format(0)
                mainTimerText.text = initializedFormatText
                subTimerText.text = initializedFormatText
            }
        }
        rightButton.setOnClickListener {
            if (rightButton.text == ButtonType.START.key) {
                prevTimeMillis = System.currentTimeMillis()
                leftButton.text = ButtonType.LAP.key
                rightButton.text = ButtonType.STOP.key
                rightButton.setTextColor(ContextCompat.getColor(this, R.color.stopButton))
                handler.post(runnable)
            } else if (rightButton.text == ButtonType.STOP.key) {
                rightButton.text = ButtonType.START.key
                rightButton.setTextColor(ContextCompat.getColor(this, R.color.startButton))
                handler.removeCallbacks(runnable)
            }
        }
    }
}
