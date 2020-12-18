package com.example.androidapp.classactivities

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidapp.R
import java.util.*

class TimepickerActivity : AppCompatActivity() {
    private lateinit var btnLoadTimePicker: Button
    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timepicker)

        btnLoadTimePicker = findViewById(R.id.btnLoadTimepicker)
        tvTime = findViewById(R.id.tvTime)

        btnLoadTimePicker.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    tvTime.text = "$hour:$minute"
                },
                hour,
                minute,
                false
            ).show()
        }
    }
}




