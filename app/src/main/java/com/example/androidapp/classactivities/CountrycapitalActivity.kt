package com.example.androidapp.classactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.androidapp.R

class CountrycapitalActivity : AppCompatActivity() {
    private val countries = arrayOf(
        "Nepal", "Kathmandu",
        "India", "New Delhi",
        "China", "Beijing"
    )
    private lateinit var countryListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countrycapital)
        countryListView = findViewById(R.id.countryListView)
        val countryCapitalMap = mutableMapOf<String, String>()
        for (i in countries.indices step 2) {
            countryCapitalMap[countries[i]] = countries[i + 1]
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countryCapitalMap.keys.toTypedArray()
        )
        countryListView.adapter = adapter
        // Item Click listener
        countryListView.setOnItemClickListener { parent, view, position, id ->
            val country = parent.getItemAtPosition(position).toString()
            val capital = countryCapitalMap[country]!!.toString()
            Toast.makeText(
                this,
                "$country's capital is $capital",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}


//        // Put all the array's element in Map
