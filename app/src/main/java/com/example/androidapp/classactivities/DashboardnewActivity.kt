package com.example.androidapp.classactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapp.R

class DashboardnewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnButton: Button
    private lateinit var btnButton2: Button

    //Main thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboardnew)
        btnButton = findViewById(R.id.btnButton)
        btnButton2 = findViewById(R.id.btnButton2)
        btnButton.setOnClickListener(this)
        btnButton2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnButton -> {
                val intent = Intent(
                    this,
                    ListviewActivity::class.java
                )
                startActivity(intent)
            }

            R.id.btnButton2 -> {
                val intent = Intent(
                    this,
                    CountrycapitalActivity::class.java
                )
                startActivity(intent)
            }
        }
    }
}