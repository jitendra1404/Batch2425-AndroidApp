package com.example.androidapp.classactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.R

class NestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)
    }
}