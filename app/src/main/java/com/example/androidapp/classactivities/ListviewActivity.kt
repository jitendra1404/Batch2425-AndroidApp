package com.example.androidapp.classactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.androidapp.R

class ListviewActivity : AppCompatActivity() {
    private val countries = arrayOf(
        "Nepal", "India", "China")
    private lateinit var lstView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        lstView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )
        lstView.adapter = adapter
        // On item Click listener
        lstView.setOnItemClickListener { parent, view, position, id ->
            val country = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, country, Toast.LENGTH_SHORT).show()
        }
    }
}