package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnDatePicker: Button
    private lateinit var btnTimePicker: Button
    private lateinit var btnAlertDialog: Button
    private lateinit var btnUserProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnDatePicker = findViewById(R.id.btnDatePicker)
        btnTimePicker = findViewById(R.id.btnTimePicker)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnUserProfile = findViewById(R.id.btnUserProfile)

        btnDatePicker.setOnClickListener(this)
        btnTimePicker.setOnClickListener(this)
        btnUserProfile.setOnClickListener(this)
        btnAlertDialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.btnDatePicker -> {
                val intent = Intent(this@DashboardActivity, DatepickerActivity::class.java)
                startActivity(intent)
            }
            R.id.btnTimePicker ->{
                val intent = Intent(this@DashboardActivity, TimepickerActivity::class.java)
                startActivity(intent)
            }
            R.id.btnUserProfile ->{
                val intent = Intent(this@DashboardActivity, UserProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.btnAlertDialog ->{
                val intent = Intent(this@DashboardActivity, AlertActivity::class.java)
                startActivity(intent)
            }
        }
    }
}