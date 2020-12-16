package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountrycapitalActivity : AppCompatActivity() {
    private val countries = arrayOf(
        "Nepal","Kathmandu",
        "India","New Delhi",
        "China","Beijing"
    )
    private lateinit var countryListView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countrycapital)

        countryListView = findViewById(R.id.countryListView)

        val countryCapitalMap = mutableMapOf<String,String>()
        // Put all the array's element in Map
        for(i in countries.indices step 2){
            // countryCapital.put(countries[i],countries[i+1])
            countryCapitalMap[countries[i]] = countries[i+1]
        }

        //Adapter
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
           // Toast.makeText(this, "Capital of $country is $capital", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,CapitalActivity::class.java)
            intent.putExtra("country",country)
            intent.putExtra("capital",capital)
            startActivity(intent)
        }
    }
}