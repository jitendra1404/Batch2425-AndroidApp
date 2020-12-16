package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CapitalActivity : AppCompatActivity() {
    private lateinit var tvCapital :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)
        tvCapital = findViewById(R.id.tvCapital)

        //Receive the value sent from another activity
        val intent = intent
        if(intent!=null){
            val country = intent.getStringExtra("country")
            val capital = intent.getStringExtra("capital")
            tvCapital.text = "$country's capital is : $capital"
        }else{
            tvCapital.text = "No values received"
        }

    }
}